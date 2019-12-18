package com.nnxy.competition.service;

import com.nnxy.competition.entity.Competition;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 15:26
 * Email    :642125256@qq.com
 */
public interface CompetitionService {
    /**
     * 通过竞赛id查询比赛详情
     * @param competitionId
     * @return
     */
    Competition findCompetitionById(String competitionId);
}
