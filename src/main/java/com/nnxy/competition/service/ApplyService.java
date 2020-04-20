package com.nnxy.competition.service;

import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.UserCompetition;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/18 16:47
 * Email    :642125256@qq.com
 */
public interface ApplyService {
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
    List<Apply> findMyApplyList(String userId, Integer applyState);

    /**
     * 获取用户所有已结束的申请，状态参数，正在申请的状态0，除去状态为0的都为已结束申请
     *
     * @param userId
     * @param applyState
     * @return
     */
    List<Apply> findMyHistoryApplyList(String userId, Integer applyState);

    /**
     * 根据用户id,申请状态，队伍id查找记录
     *
     * @param apply
     * @return
     */
    Boolean findApplyByUserIdAndApplyStateAndTeamId(Apply apply);

    /**
     * 根据申请id删除申请
     *
     * @param applyId
     */
    void deleteTeamApply(String applyId);
}
