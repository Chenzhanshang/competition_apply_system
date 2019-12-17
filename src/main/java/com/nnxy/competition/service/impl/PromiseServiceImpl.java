package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.PromiseDao;
import com.nnxy.competition.entity.Promise;
import com.nnxy.competition.entity.Role;
import com.nnxy.competition.service.PromiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:25
 * Email 642125256@qq.com
 */
@Service
public class PromiseServiceImpl implements PromiseService {

    @Autowired
    private PromiseDao promiseDao;

    @Override
    public Set<Promise> getPromiseByRole(Set<Role> roles) {
        return promiseDao.getPromiseByRole(roles);
    }
}
