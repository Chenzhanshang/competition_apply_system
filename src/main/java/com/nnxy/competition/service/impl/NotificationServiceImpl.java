package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.NotificationDao;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.service.NotificationService;
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
    NotificationDao notificationDao;

    @Override
    public List<Notification> findNotificationByType(Integer notificationType) {
        List<Notification> notifications = notificationDao.findNotificationByType(notificationType);
        return notifications;
    }
}
