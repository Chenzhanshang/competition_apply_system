package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.AdviceDao;
import com.nnxy.competition.entity.Advice;
import com.nnxy.competition.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2020/3/3 15:10
 * Email    :642125256@qq.com
 */
@Service
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    private AdviceDao adviceDao;
    @Override
    public void insertAdvice(Advice advice) {
        adviceDao.insertAdvice(advice);
    }

    @Override
    public List<Advice> getAllAdvice(Integer adviceState) {
        return adviceDao.getAllAdvice(adviceState);
    }

    @Override
    public void updateAdvice(Advice advice) {
        adviceDao.updateAdvice(advice);
    }
}
