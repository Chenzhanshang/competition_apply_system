package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.CollegeDao;
import com.nnxy.competition.dao.CompetitionDao;
import com.nnxy.competition.dao.FileDao;
import com.nnxy.competition.dao.NotificationDao;
import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.service.NotificationService;
import com.nnxy.competition.utils.CompetitionNotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 10:29
 * Email    :642125256@qq.com
 */

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;
    @Autowired
    private CompetitionDao competitionDao;
    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    private FileDao fileDao;

    @Override
    public List<Notification> findNotificationByType(Integer notificationType) {
        List<Notification> notifications = notificationDao.findNotificationByType(notificationType);
        return notifications;
    }

    @Override
    public List<Notification> findSystemNoticeByTypeAndState(Integer notificationType,Integer notificationState) {
        List<Notification> notifications = notificationDao.findSystemNoticeByTypeAndState(notificationType,notificationState);
        return notifications;
    }

    @Override
    public void insertCompetitionAndNotification( Competition competition, Notification notification) {
        competitionDao.insertCompetition(competition);
        notificationDao.insertNotification(notification);
    }



    @Override
    public Notification findDataByNotificationId(String notificationId) {
        Notification notification = notificationDao.findDataByNotificationId(notificationId);

        return notification;
    }

    @Override
    public void deleteNotificationById(String notificationId, String competitionId) {
        //删通知
        notificationDao.deleteNotificationById(notificationId);
        //删竞赛文件
        fileDao.deleteFileByCompetitionId(competitionId);
        //删竞赛
        competitionDao.deleteCompetitionById(competitionId);

    }

    @Override
    public void updateNotification(CompetitionNotificationVO competitionNotificationVO) {
        notificationDao.updateNotification(competitionNotificationVO);
        competitionDao.updateCompetition(competitionNotificationVO);
    }
}
