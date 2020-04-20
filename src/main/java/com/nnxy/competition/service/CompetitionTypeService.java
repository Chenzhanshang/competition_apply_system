package com.nnxy.competition.service;

import com.nnxy.competition.entity.CompetitionType;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/20 15:02
 * Email    :642125256@qq.com
 */
public interface CompetitionTypeService {
    /**
     * 获取全部比赛类型
     *
     * @return
     */
    List<CompetitionType> findAllCompetitionType();
}
