package com.nnxy.competition.service;

import com.nnxy.competition.entity.Notification;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/24 14:34
 * Email    :642125256@qq.com
 */
public interface WinNotificationService {
    /**
     * 获取所有获奖通知
     *
     * @param notificationType
     * @return
     */
    public List<Notification> findAllWinNotification(Integer notificationType);


    /**
     * 保存新获奖通知
     *
     * @param notification
     * @return
     */
    void insertWinNotification(Notification notification);

    /**
     * 删除获奖通知
     *
     * @param notificationId
     * @param competitionId
     * @return
     */
    void deleteWinNotificationById(String notificationId, String competitionId);

    /**
     * 修改获奖通知
     *
     * @param notification
     * @return
     */
    void updateWinNotification(Notification notification);
}
