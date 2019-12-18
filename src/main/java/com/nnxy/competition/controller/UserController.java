package com.nnxy.competition.controller;

import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.UserService;
import com.nnxy.competition.utils.ErrorEnum;
import com.nnxy.competition.utils.ResponseMessage;
import com.nnxy.competition.utils.SuccessEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author  :CZS
 * @date    :2019/12/17 13:31
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage login(@RequestBody User user){
        System.out.println(user);
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            System.out.println("用户未登录");
            //如果用户未登录，执行登录逻辑
            try {
                UsernamePasswordToken usernamePasswordToken =
                        new UsernamePasswordToken(user.getUserName(),user.getPassword());
                // 执行认证提交
                subject.login(usernamePasswordToken);
                //返回登录成功信息
                ResponseMessage responseMessage = new ResponseMessage(SuccessEnum.S_LOGIN_SUCCESS);
                //获取用户的信息
                User principal = (User) subject.getPrincipal();


                //将角色返回
                responseMessage.getData().put("roles",
                        principal.getRoles());
                System.out.println( principal.getRoles());
                return responseMessage;
            }
            catch (UnknownAccountException e){
                e.printStackTrace();
                //返回用户不存在
                return new ResponseMessage(ErrorEnum.E_UNKNOWN_ACCOUNT);
            }
            catch (AuthenticationException e) {
                e.printStackTrace();
                //返回密码错误信息
                return new ResponseMessage(ErrorEnum.E_PASSWORD_ERROR);
            }
        }
        else{
            //如果用户已经登录则无需执行登录轮逻辑，直接返回登录成功
            return new ResponseMessage(SuccessEnum.S_LOGINED);
        }

    }


    /**
     * 用户个人信息
     * @return
     */
    @RequestMapping("/findUserByUsername")
    @ResponseBody
    public User  findUserByUsername(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        user = userService.findUserByUsername(user.getUserName());
        System.out.println(user);

        return user;
    }

    @Autowired
    private RedisTemplate redisTemplate; //注入


    @RequestMapping("/add")
    public String addStudent() {
        System.out.println("add");
        try {
            redisTemplate.opsForValue().set("test", "测试");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
