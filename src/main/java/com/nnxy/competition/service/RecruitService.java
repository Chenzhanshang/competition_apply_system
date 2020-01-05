package com.nnxy.competition.service;

import com.nnxy.competition.entity.Team;

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
}
