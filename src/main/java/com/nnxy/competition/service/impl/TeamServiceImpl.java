package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.TeamDao;
import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/27 12:13
 * Email    :642125256@qq.com
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public void insertTeam(Team team) {
        teamDao.insertTeam(team);
        //将自己增加到队伍中
        teamDao.insertUserTeam(team.getTeamId(),team.getCaptain().getUserId());
    }

    @Override
    public List<Team> findMyTeam(String userId) {
        List<Team> teams = teamDao.findMyTeam(userId);
        return teams;
    }

    @Override
    public List<User> findUsersByTeamIdAndNotNowUser(String teamId, String userId) {
        List<User> users = teamDao.findUsersByTeamIdAndNotNowUser(teamId, userId);
        return users;
    }

    @Override
    public void updateMyTeam(Team team) {
        teamDao.updateMyTeam(team);
    }

    @Override
    public void deleteTeamUser(String teamId, String userId) {
        teamDao.deleteTeamUser(teamId, userId);
    }

    @Override
    public void deleteTeam(String teamId) {
        //通过队伍id删除所有队员
        teamDao.deleteTeamUserByTeamId(teamId);
        teamDao.deleteTeam(teamId);
    }

    @Override
    public List<Team> findJoinTeam(String userId) {
        List<Team> teams = teamDao.findJoinTeam(userId);
        return teams;
    }

    @Override
    public void deleteTeamOneUser(String teamId, String userId) {
        teamDao.deleteTeamUser(teamId, userId);
    }

    @Override
    public List<Apply> findAllMyTeamApply(List<Team> teams) {
        if(teams == null || teams.size() == 0){
            return null;
        }
        List<Apply> applies = teamDao.findAllMyTeamApply(teams);
        return applies;
    }

    @Override
    public List<Apply> findAllMyHistoryTeamApply(List<Team> teams) {
        if(teams == null || teams.size() == 0){
            return null;
        }
        //获取审批过的申请列表
        List<Apply> applies = teamDao.findAllMyDispose(teams);
        return applies;
    }

    @Override
    public void updateTeam(Team team) {
        teamDao.updateTeam(team);
    }

    @Override
    public Team findTeamByCaptainIdAndCompetitionId(String userId, String competitionId) {
        Team team = teamDao.findTeamByCaptainIdAndCompetitionId(userId, competitionId);
        return team;
    }

    @Override
    public void updateTeamCancelApply(String teamId) {
        teamDao.updateTeamCancelApply(teamId);
    }
}
