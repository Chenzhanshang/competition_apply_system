package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Promise;
import com.nnxy.competition.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:22
 * Email 642125256@qq.com
 */
@Mapper
public interface PromiseDao {

    /**
     * 通过角色获取权限
     * @param roles
     * @return
     */
    public Set<Promise> getPromiseByRole(Set<Role> roles);
}



