package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Role;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.UserService;
import com.nnxy.competition.utils.ErrorEnum;
import com.nnxy.competition.utils.ResponseMessage;
import com.nnxy.competition.utils.SuccessEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author :CZS
 * @date :2019/12/17 13:31
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage login(@RequestBody User user) {
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            System.out.println("用户未登录");
            //如果用户未登录，执行登录逻辑
            try {
                UsernamePasswordToken usernamePasswordToken =
                        new UsernamePasswordToken(user.getUserName(), user.getPassword());
                // 执行认证提交
                subject.login(usernamePasswordToken);
                //返回登录成功信息
                ResponseMessage responseMessage = new ResponseMessage(SuccessEnum.S_LOGIN_SUCCESS);
                //获取用户的信息
                User principal = (User) subject.getPrincipal();

                for (Role role : principal.getRoles()) {
                    if (role.getRoleId().equals(user.getRoles().iterator().next().getRoleId())) {
                        //将角色返回
                        responseMessage.getData().put("roles",
                                principal.getRoles());
                        System.out.println(principal.getRoles());
                        return responseMessage;
                    }
                }
                if ("1".equals(user.getRoles().iterator().next().getRoleId())) {
                    //无该角色，登出（后同）
                    if (SecurityUtils.getSubject().isAuthenticated()) {
                        subject.logout();
                    }
                    return new ResponseMessage(ErrorEnum.E_NOTADMIN);
                } else if ("2".equals(user.getRoles().iterator().next().getRoleId())) {
                    if (SecurityUtils.getSubject().isAuthenticated()) {
                        subject.logout();
                    }
                    return new ResponseMessage(ErrorEnum.E_NOTSTUDENT);
                } else {
                    if (SecurityUtils.getSubject().isAuthenticated()) {
                        subject.logout();
                    }
                    return new ResponseMessage(ErrorEnum.E_NOTROLE);

                }

            } catch (UnknownAccountException e) {
                e.printStackTrace();
                //返回用户不存在
                return new ResponseMessage(ErrorEnum.E_UNKNOWN_ACCOUNT);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                //返回密码错误信息
                return new ResponseMessage(ErrorEnum.E_PASSWORD_ERROR);
            }
        } else {
            //如果用户已经登录则无需执行登录轮逻辑，直接返回登录成功
            return new ResponseMessage(SuccessEnum.S_LOGINED);
        }

    }


    /**
     * 用户个人信息
     *
     * @return
     */
    @RequestMapping("/findUserByUsername")
    @ResponseBody
    public User findUserByUsername() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user = userService.findUserByUserName(user.getUserName());
        return user;
    }

    /**
     * 修改用户密码
     *
     * @param u
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updatePassword(@RequestBody User u) {
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            //获取盐值
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
            //加密密码
            SimpleHash simpleHash = new SimpleHash("MD5", u.getPassword(), credentialsSalt, 1024);
            user.setPassword(simpleHash.toString());
            userService.updatePassword(user);
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                subject.logout();
            }
            return new ResponseMessage("1", "修改成功,请重新登录！");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "修改失败");
        }
    }

    /**
     * 注销登录
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                subject.logout();
                return new ResponseMessage("1", "退出成功");
            } else {
                return new ResponseMessage(ErrorEnum.E_UNAUTHENTICATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "退出失败");
        }
    }

    /**
     * 根据用户id查找用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getUserByUserId")
    @ResponseBody
    public User getUserByUserId(String userId) {
        User user = userService.findUserByUserId(userId);
        return user;
    }

    //判断是否登录
    @RequestMapping("/isLogin")
    public @ResponseBody
    ResponseMessage isLogin() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return new ResponseMessage("200", "已登录");
        }
        return new ResponseMessage("1001", "未登录,自动跳转到登录界面！");
    }

    /**
     * 获得所有用户
     *
     * @return
     */
    @RequestMapping("/getAllUser")
    @ResponseBody
    public ResponseMessage getAllUser() {
        List<User> users = null;
        try {
            users = userService.getAllUser();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("userList",users);
            return responseMessage;

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

}
