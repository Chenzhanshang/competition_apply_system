package com.nnxy.competition.service;

import com.nnxy.competition.entity.Notification;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 10:27
 * Email    :642125256@qq.com
 */
public interface NotificationService {
    /**
     * 通知类型查找通知
     * @param notificationType
     * @return
     */
    public List<Notification> findNotificationByType(Integer notificationType);
}
