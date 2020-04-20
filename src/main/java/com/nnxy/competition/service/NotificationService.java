package com.nnxy.competition.service;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.utils.CompetitionNotificationVO;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/18 10:27
 * Email    :642125256@qq.com
 */
public interface NotificationService {
    /**
     * 通知类型查找通知
     *
     * @param notificationType
     * @return
     */
    public List<Notification> findNotificationByType(Integer notificationType);

    /**
     * 通知类型和状态查找系统公告
     *
     * @param notificationType
     * @param notificationState
     * @return
     */
    List<Notification> findSystemNoticeByTypeAndState(Integer notificationType, Integer notificationState);

    /**
     * 将新通知，比赛
     *
     * @param notification
     * @param competition
     * @return
     */
    void insertCompetitionAndNotification(Competition competition, Notification notification);


    /**
     * 根据通知id查找内容，用于回显修改通知的信息
     *
     * @param notificationId
     * @return
     */
    Notification findDataByNotificationId(String notificationId);

    /**
     * 根据通知id删除对应通知及文件，竞赛
     *
     * @param notificationId
     * @return
     */
    void deleteNotificationById(String notificationId, String competitionId);


    /**
     * 修改竞赛通知及竞赛文件，竞赛内容
     *
     * @param competitionNotificationVO
     * @return
     */
    void updateNotification(CompetitionNotificationVO competitionNotificationVO);
}

