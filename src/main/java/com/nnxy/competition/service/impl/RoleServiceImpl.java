package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.RoleDao;
import com.nnxy.competition.entity.Role;
import com.nnxy.competition.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:27
 * Email 642125256@qq.com
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<Role> getRoleByUserId(String userId) {
        return roleDao.getRoleByUserId(userId);
    }
}
