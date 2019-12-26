package com.nnxy.competition.dao;

import com.nnxy.competition.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/19 23:31
 * Email    :642125256@qq.com
 */
@Mapper
public interface FileDao {
    /**
     * 插入新文件
     * @param file
     * @return
     */
    void insertFile(File file);

    /**
     * 根据比赛id查询文件
     * @param competitionId
     * @return
     */
    List<File> findFileByCompetitionId(String competitionId);

    /**
     * 根据比赛id删除文件
     * @param CompetitionId
     * @return
     */
    void deleteFileByCompetitionId(String CompetitionId);

    /**
     * 根据文件id搜索文件
     * @param fileId
     * @return
     */
    File findFileById(String fileId);

    /**
     * 根据文件id删除文件
     * @param fileId
     * @return
     */
    void deleteFileById(String fileId);

    /**
     * 根据公告id查询文件
     * @param notificationId
     * @return
     */
    List<File> findFileByNotificationId(String notificationId);

    /**
     * 根据公告id删除文件
     * @param notificationId
     * @return
     */
    void deleteFileByNnotificationId(String notificationId);
}
