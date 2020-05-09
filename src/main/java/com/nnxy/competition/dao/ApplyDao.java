package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.entity.UserTeam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 处理报名及获奖信息
 *
 * @author :CZS
 * @date :2019/12/18 17:00
 * Email    :642125256@qq.com
 */
@Mapper
public interface ApplyDao {

    /**
     * 保存报名信息
     *
     * @param userCompetition
     * @return
     */
    public void insertApply(UserCompetition userCompetition);

    /**
     * 根据用户id和竞赛id查询报名信息
     *
     * @param userCompetition
     * @return
     */
    public UserCompetition findApplyByUserIdAndCompetitionId(UserCompetition userCompetition);

    /**
     * 根据用户id和竞赛id删除报名信息
     *
     * @param userCompetition
     */
    void deleteApply(UserCompetition userCompetition);

    /**
     * 根据竞赛id获取获奖列表
     *
     * @param competitionId
     * @return
     */
    List<UserCompetition> findWinByCompetitionId(String competitionId);

    /**
     * 保存队伍申请
     *
     * @param apply
     * @return
     */
    void insertTeamApply(Apply apply);

    /**
     * 通过处理加入队伍的结果，修改申请信息
     *
     * @param apply
     */
    void updateApplyByDispose(Apply apply);

    /**
     * 获取用户所有申请中的申请
     *
     * @param userId
     * @param applyState
     * @return
     */
    List<Apply> findMyApplyList(@Param("userId") String userId, @Param("applyState") Integer applyState);

    /**
     * 获取用户所有已结束的申请，状态参数，正在申请的状态0，除去状态为0的都为已结束申请
     *
     * @param userId
     * @param applyState
     * @return
     */
    List<Apply> findMyHistoryApplyList(@Param("userId") String userId, @Param("applyState") Integer applyState);

    /**
     * 保存用户-队伍信息
     *
     * @param userTeam
     */
    void insertUserTeam(UserTeam userTeam);

    /**
     * 根据用户id,申请状态，队伍id查找记录
     *
     * @param apply
     * @return
     */
    Apply findApplyByUserIdAndApplyStateAndTeamId(Apply apply);

    /**
     * 根据申请id删除申请
     *
     * @param applyId
     */
    void deleteTeamApply(String applyId);

    /**
     * 删除队伍所有申请
     * @param teamId
     */
    void deleteApplyByTeamId(String teamId);
}
