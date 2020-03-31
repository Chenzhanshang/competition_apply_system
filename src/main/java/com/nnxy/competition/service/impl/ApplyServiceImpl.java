package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.ApplyDao;
import com.nnxy.competition.dao.TeamDao;
import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.entity.UserTeam;
import com.nnxy.competition.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private TeamDao teamDao;
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

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void updateApplyByDispose(Apply apply) {
        applyDao.updateApplyByDispose(apply);
        //如果为通过加入队伍操作
        if(apply.getApplyState() == 1){
            UserTeam userTeam = new UserTeam();
            userTeam.setUserId(apply.getUser().getUserId());
            userTeam.setTeamId(apply.getTeam().getTeamId());
            System.out.println(userTeam);
            //保存用户-队伍对应信息
            applyDao.insertUserTeam(userTeam);
            teamDao.updateTeamStateAndHeadCount(apply.getTeam());
        }

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

    @Override
    public Boolean findApplyByUserIdAndApplyStateAndTeamId(Apply apply) {
        if(applyDao.findApplyByUserIdAndApplyStateAndTeamId(apply) != null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteTeamApply(String applyId) {
        applyDao.deleteTeamApply(applyId);
    }
}
