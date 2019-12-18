package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.ApplyDao;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 16:55
 * Email    :642125256@qq.com
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyDao applyDao;
    @Override
    public void insertApply(UserCompetition userCompetition) {
        applyDao.insertApply(userCompetition);
    }

    @Override
    public UserCompetition findApplyByUserIdAndCompetitionId(UserCompetition userCompetition) {
        UserCompetition uc = applyDao.findApplyByUserIdAndCompetitionId(userCompetition);
        return uc;
    }
}
