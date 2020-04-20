package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.UserTeam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/30 11:39
 * Email    :642125256@qq.com
 */

@Mapper
public interface RecruitDao {
    /**
     * 根据队伍状态获取队伍列表
     *
     * @param teamState
     * @param captainId
     * @return
     */
    public List<Team> findAllTeamByState(@Param("teamState") Integer teamState, @Param("captainId") String captainId);

    /**
     * 查询该用户的所有加入的队伍列表
     *
     * @param userId
     * @return
     */
    List<UserTeam> findAllUserTeam(String userId);
}
