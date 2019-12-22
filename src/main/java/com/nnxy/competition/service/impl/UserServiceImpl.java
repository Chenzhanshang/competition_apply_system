package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.UserDao;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  :CZS
 * @date    :2019/12/14 13:13
 * Email    :642125256@qq.com
 */
@Service
public class UserServiceImpl implements UserService {
    //注意@Resource 与 @Autowired 区别
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsernameAndPassword(User user) {
        User u = userDao.findByUsernameAndPassword(user);
        return u;
    }

    @Override
    public String findCollegeIdByUserName(String userName) {
        String collegeId = userDao.findCollegeIdByUserName(userName);
        return collegeId;
    }

    @Override
    public User findUserByUsername(String userName) {
        User user = userDao.findUserByUsername(userName);
        return user;
    }



    @Override
    public void updatePasswordByAdminAccount(User user) {
        //利用Account做盐值进行1024次加密
        SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword(),
                user.getUserName(), 1024);
        //设置密码
        user.setPassword(simpleHash.toString());

        userDao.updateUserByUserName(user);

    }
}
