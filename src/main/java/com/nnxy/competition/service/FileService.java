package com.nnxy.competition.service;

import com.nnxy.competition.entity.File;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/20 9:28
 * Email    :642125256@qq.com
 */
public interface FileService {
    /**
     * 插入新文件
     * @param file
     * @return
     */
    void insertFile(File file);

    /**
     * 根据比赛id查询文件
     * @param CompetitionId
     * @return
     */
    List<File> findFileByCompetitionId(String CompetitionId);

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

}
