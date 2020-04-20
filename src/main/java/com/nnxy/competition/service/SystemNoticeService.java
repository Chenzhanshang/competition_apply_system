package com.nnxy.competition.service;

import com.nnxy.competition.entity.Notification;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/22 17:26
 * Email    :642125256@qq.com
 */
public interface SystemNoticeService {

    /**
     * 根据类型获取通知
     *
     * @param notificationType
     * @return
     */
    List<Notification> findNoticeByType(Integer notificationType);


    /**
     * 保存新的公告内容
     *
     * @param notification
     * @return
     */
    void insertNotice(Notification notification);

    /**
     * 删除公告
     *
     * @param notificationId
     * @return
     */
    void deleteNotificationById(String notificationId);

    /**
     * 更新公告
     *
     * @param notification
     * @return
     */
    void updateNotification(Notification notification);
}
