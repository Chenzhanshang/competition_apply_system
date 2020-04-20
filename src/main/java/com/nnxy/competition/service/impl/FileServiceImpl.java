package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.FileDao;
import com.nnxy.competition.entity.File;
import com.nnxy.competition.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/20 9:28
 * Email    :642125256@qq.com
 */

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public void insertFile(File file) {
        fileDao.insertFile(file);
    }

    @Override
    public List<File> findFileByCompetitionId(String competitionId) {
        List<File> files = fileDao.findFileByCompetitionId(competitionId);
        return files;
    }

    @Override
    public void deleteFileByCompetitionId(String CompetitionId) {
        fileDao.deleteFileByCompetitionId(CompetitionId);
    }

    @Override
    public File findFileById(String fileId) {
        File file = fileDao.findFileById(fileId);
        return file;
    }

    @Override
    public void deleteFileById(String fileId) {
        fileDao.deleteFileById(fileId);
    }

    @Override
    public List<File> findFileByNotificationId(String notificationId) {
        List<File> files = fileDao.findFileByNotificationId(notificationId);
        return files;
    }

}
