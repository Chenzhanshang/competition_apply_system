package com.nnxy.competition.realm;

import com.nnxy.competition.entity.Promise;
import com.nnxy.competition.entity.Role;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.PromiseService;
import com.nnxy.competition.service.RoleService;
import com.nnxy.competition.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:50
 * Email 642125256@qq.com
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PromiseService promiseService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //开始获取权限
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if(primaryPrincipal instanceof User){
            User user = (User) primaryPrincipal;

            //获取user的角色
            Set<Role> roleSet = roleService.getRoleByUserId(user.getUserId());
            Set<String> roles = new HashSet<>();
            for (Role role:roleSet) {
                roles.add(role.getRoleName());
            }
            simpleAuthorizationInfo.addRoles(roles);

            //通过角色获取权限
            Set<Promise> promiseSet = promiseService.getPromiseByRole(roleSet);
            Set<String> promises = new HashSet<>();
            for (Promise promise:promiseSet) {
                promises.add(promise.getPromiseName());
            }
            simpleAuthorizationInfo.addStringPermissions(promises);
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken)authenticationToken;
        //从数据库中获取用户信息
        System.out.println(userService.findUserByUserName(upToken.getUsername()));
        User userFindUserByUsername = userService.findUserByUserName(upToken.getUsername());
        if (userFindUserByUsername == null){
            throw new UnknownAccountException("用户不存在");
        }
        userFindUserByUsername.setRoles(roleService.getRoleByUserId(userFindUserByUsername.getUserId()));
//        //盐值 以用户名作为盐值
//        //配置文件中标明用MD5加密了1024次
        ByteSource credentialsSalt = ByteSource.Util.bytes(userFindUserByUsername.getUserName());
        SimpleAuthenticationInfo info = null;
        //比对密码
        info = new SimpleAuthenticationInfo(userFindUserByUsername,userFindUserByUsername.getPassword(),credentialsSalt,this.getName());
        return info;
    }

//    @Test
////    public void func(){
////        String fun = "MD5";
////        String pwd = "123456";
////        ByteSource credentialsSalt = ByteSource.Util.bytes("czs12138");
////        int i = 1024;
////        SimpleHash simpleHash = new SimpleHash(fun, pwd, credentialsSalt, i);
////        System.out.println(simpleHash);
////    }


}
