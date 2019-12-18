package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Competition;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :CZS
 * @date :2019/12/18 15:19
 * Email    :642125256@qq.com
 */
@Mapper
public interface CompetitionDao {
     /**
     * 通过竞赛id查询比赛详情
     * @param competitionId
     * @return
     */
    Competition findCompetitionById(String competitionId);
}
