package com.nnxy.competition.service;


import com.nnxy.competition.entity.Promise;
import com.nnxy.competition.entity.Role;

import java.util.Set;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:18
 * Email 642125256@qq.com
 */
public interface PromiseService {

    /**
     * 通过角色获取权限
     *
     * @param roles
     * @return
     */
    public Set<Promise> getPromiseByRole(Set<Role> roles);
}
