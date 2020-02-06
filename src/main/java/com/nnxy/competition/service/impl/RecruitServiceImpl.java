package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.RecruitDao;
import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.entity.UserTeam;
import com.nnxy.competition.service.RecruitService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/30 11:38
 * Email    :642125256@qq.com
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;

    @Override
    public List<Team> findAllTeamByState(Integer teamState) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Team> teams = recruitDao.findAllTeamByState(teamState, user.getUserId());
        return teams;
    }

    @Override
    public List<UserTeam> findAllUserTeam(String userId) {
        List<UserTeam> userTeams = recruitDao.findAllUserTeam(userId);
        return userTeams;
    }
}
