package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.ApplyDao;
import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteApply(UserCompetition userCompetition) {
        applyDao.deleteApply(userCompetition);
    }

    @Override
    public List<UserCompetition> findWinByCompetitionId(String competitionId) {
        List<UserCompetition> userCompetitions = applyDao.findWinByCompetitionId(competitionId);
        return userCompetitions;
    }

    @Override
    public void insertTeamApply(Apply apply) {
        applyDao.insertTeamApply(apply);
    }

    @Override
    public void updateApplyByDispose(Apply apply) {
        applyDao.updateApplyByDispose(apply);
    }

    @Override
    public List<Apply> findMyApplyList(String userId, Integer applyState) {
        List<Apply> applies = applyDao.findMyApplyList(userId, applyState);
        return applies;
    }

    @Override
    public List<Apply> findMyHistoryApplyList(String userId, Integer applyState) {
        List<Apply> applies = applyDao.findMyHistoryApplyList(userId, applyState);
        return applies;
    }
}
