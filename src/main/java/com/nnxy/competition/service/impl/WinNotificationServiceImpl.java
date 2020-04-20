package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.FileDao;
import com.nnxy.competition.dao.NotificationDao;
import com.nnxy.competition.dao.WinNotificationServiceDao;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.service.WinNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/24 14:35
 * Email    :642125256@qq.com
 */
@Service
public class WinNotificationServiceImpl implements WinNotificationService {
    @Autowired
    private WinNotificationServiceDao winNotificationServiceDao;

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private FileDao fileDao;


    @Override
    public List<Notification> findAllWinNotification(Integer notificationType) {
        List<Notification> notifications = winNotificationServiceDao.findAllWinNotification(notificationType);
        return notifications;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void insertWinNotification(Notification notification) {
        winNotificationServiceDao.insertWinNotification(notification);
        if (notification.getUserIds() != null && notification.getUserIds().size() != 0) {
            Integer ranking = 1;
            String competitionId = notification.getCompetition().getCompetitionId();
            for (String userId : notification.getUserIds()) {
                winNotificationServiceDao.updateWinRanking(userId, competitionId, ranking);
                ranking++;
            }

        }
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteWinNotificationById(String notificationId, String competitionId) {
        //先删除文件
        fileDao.deleteFileByNnotificationId(notificationId);
        notificationDao.deleteNotificationById(notificationId);
        winNotificationServiceDao.deleteWin(competitionId);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateWinNotification(Notification notification) {
        winNotificationServiceDao.updateWinNotification(notification);
        //如果数组中有元素，清空原有获奖记录信息，重新存储
        if (notification.getUserIds() != null && notification.getUserIds().size() != 0) {
            //清空
            winNotificationServiceDao.deleteWin(notification.getCompetition().getCompetitionId());
            Integer ranking = 1;
            String competitionId = notification.getCompetition().getCompetitionId();
            for (String userId : notification.getUserIds()) {
                winNotificationServiceDao.updateWinRanking(userId, competitionId, ranking);
                ranking++;
            }
        }
    }

}
