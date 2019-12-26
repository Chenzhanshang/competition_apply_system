package com.nnxy.competition.service;

import com.nnxy.competition.entity.UserCompetition;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 16:47
 * Email    :642125256@qq.com
 */
public interface ApplyService {
     /**
     * 保存报名信息
     * @param userCompetition
     * @return
     */
    public void insertApply(UserCompetition userCompetition);

    /**
     * 根据用户id和竞赛id查询报名信息
     * @param userCompetition
     * @return
     */
    public UserCompetition findApplyByUserIdAndCompetitionId(UserCompetition userCompetition);

    /**
     * 根据用户id和竞赛id删除报名信息
     * @param userCompetition
     */
    void deleteApply(UserCompetition userCompetition);

    /**
     * 根据竞赛id获取获奖列表
     * @param competitionId
     * @return
     */
    List<UserCompetition> findWinByCompetitionId(String competitionId);
}
