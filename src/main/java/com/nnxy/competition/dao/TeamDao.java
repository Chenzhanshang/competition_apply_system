package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/27 12:14
 * Email    :642125256@qq.com
 */
@Mapper
public interface TeamDao {
    /**
     * 保存新创建队伍信息
     * @param team
     * @return
     */
    public void insertTeam(Team team);

    /**
     * 获取当前用户创建的所有队伍
     * @param userId
     * @return
     */
    List<Team> findMyTeam(String userId);

    /**
     * 根据队伍id和自己的id获得除自己以外的成员列表
     * @param teamId
     * @param userId
     * @return
     */
    List<User> findUsersByTeamIdAndNotNowUser(String teamId, String userId);

    /**
     * 根据队伍id和自己的id增加到队伍中
     * @param teamId
     * @param userId
     * @return
     */
    void insertUserTeam(String teamId, String userId);

    /**
     * 根据队伍信息修改数据库队伍数据
     * @param team
     * @return
     */
    void updateMyTeam(Team team);

    /**
     * 删除队伍中的成员
     * @param teamId
     * @param userId
     */
    void deleteTeamUser(String teamId, String userId);

    /**
     * 解散队伍，并清空队员
     * @param teamId
     */
    void deleteTeam(String teamId);

    /**
     * 通过队伍id删除所有队员
     * @param teamId
     */
    void deleteTeamUserByTeamId(String teamId);

    /**
     * 获取当前用户加入的所有队伍
     * @param userId
     * @return
     */
    List<Team> findJoinTeam(String userId);

    /**
     * 根据用户所有比赛获取所有申请
     * @param teams
     * @param applyState
     * @return
     */
    List<Apply> findAllMyTeamApply(@Param("teams") List<Team> teams, @Param("applyState") Integer applyState);
}
