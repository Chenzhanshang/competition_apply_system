package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.UserDao;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.UserService;
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
    public User findUserByUserName(String userName) {
        User user = userDao.findUserByUserName(userName);
        return user;
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }

    @Override
    public User findUserByUserId(String userId) {
        User user = userDao.findUserByUserId(userId);
        return user;
    }


}
