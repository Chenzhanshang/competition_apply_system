package com.nnxy.competition.dao;

import com.nnxy.competition.entity.UserCompetition;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
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
}
