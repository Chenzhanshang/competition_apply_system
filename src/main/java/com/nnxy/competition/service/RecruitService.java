package com.nnxy.competition.service;

import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.UserTeam;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/30 11:37
 * Email    :642125256@qq.com
 */
public interface RecruitService {

    /**
     * 根据队伍状态获取队伍列表
     * @param teamState
     * @return
     */
    public List<Team> findAllTeamByState(Integer teamState) ;

    /**
     * 查询该用户的所有加入的队伍列表
     * @param  userId
     * @return
     */
    List<UserTeam> findAllUserTeam(String userId);
}
