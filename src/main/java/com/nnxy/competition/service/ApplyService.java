package com.nnxy.competition.service;

import com.nnxy.competition.entity.UserCompetition;

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
}
