package com.nnxy.competition.service;

import com.nnxy.competition.entity.Role;

import java.util.Set;


/**
 * @author CZS
 * CreateTime 2019/12/13 11:17
 * Email 642125256@qq.com
 */
public interface RoleService {

    /**
     * 通过adminid获取角色
     *
     * @param userId
     * @return
     */
    public Set<Role> getRoleByUserId(String userId);

}
