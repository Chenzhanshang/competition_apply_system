package com.nnxy.competition.dao;

import com.nnxy.competition.entity.UserCompetition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 处理报名及获奖信息
 * @author  :CZS
 * @date    :2019/12/18 17:00
 * Email    :642125256@qq.com
 */
@Mapper
public interface ApplyDao {

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
