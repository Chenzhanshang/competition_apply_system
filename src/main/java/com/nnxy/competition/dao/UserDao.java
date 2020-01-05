package com.nnxy.competition.dao;

import com.nnxy.competition.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author CZS
 * CreateTime 2019/12/4 11:17
 * Email 642125256@qq.com
 */
@Mapper
public interface UserDao {

    /**
     * 通过用户名，密码查询用户
     * @param user
     * @return
     */
    User findByUsernameAndPassword(User user);

    /**
     * 通过用户名查询学院id
     * @param userName
     * @return
     */
    String findCollegeIdByUserName(String userName);

    /**
     * 通过userName查询所有用户信息
     * @param userName
     * @return
     */
    User findUserByUsername(String userName);


    /**
     * 通过userName修改密码
     * @param user
     */
    void updateUserByUserName(User user);

    /**
     * 修改用户密码
     * @param user
     */
    void updatePassword(User user);

}
