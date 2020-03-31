package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.FileDao;
import com.nnxy.competition.dao.NotificationDao;
import com.nnxy.competition.dao.SystemNoticeDao;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.service.SystemNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/22 17:28
 * Email    :642125256@qq.com
 */
@Service
public class SystemNoticeServiceImpl implements SystemNoticeService {
    @Autowired
    private SystemNoticeDao systemNoticeDao;

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private FileDao fileDao;

    @Override
    public List<Notification> findNoticeByType(Integer notificationType) {
        List<Notification> notifications = systemNoticeDao.findNoticeByType(notificationType);
        return notifications;
    }

    @Override
    public void insertNotice(Notification notification) {
        systemNoticeDao.insertNotice(notification);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteNotificationById(String notificationId) {
        //先删除文件，文件引用公告外键
        fileDao.deleteFileByNnotificationId(notificationId);
        notificationDao.deleteNotificationById(notificationId);

    }

    @Override
    public void updateNotification(Notification notification) {
        systemNoticeDao.updateNotification(notification);
    }
}
