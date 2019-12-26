package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.utils.CompetitionNotificationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 通过竞赛id删除比赛
     * @param competitionId
     * @return
     */
    void deleteCompetitionById(String competitionId);

    /**
     * 插入新比赛
     * @param competition
     * @return
     */
    void insertCompetition(Competition competition);

    /**
     * 修改竞赛通知及竞赛文件，竞赛内容
     *
     * @param competitionNotificationVO
     * @return
     */
    void updateCompetition(CompetitionNotificationVO competitionNotificationVO);

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
