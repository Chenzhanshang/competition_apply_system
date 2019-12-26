package com.nnxy.competition.service;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.User;

import java.util.List;

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

    /**
     * 查询所有比赛详情
     * @return
     */
    List<Competition> findAllCompetition();

    /**
     * 根据比赛id获得参赛列表
     * @param competitionId
     * @return
     */
    List<User> findUserByCompetitionId(String competitionId);
}
