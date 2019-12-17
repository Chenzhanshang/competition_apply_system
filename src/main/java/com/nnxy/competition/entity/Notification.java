package com.nnxy.competition.entity;

import java.util.List;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:10
 * Email 642125256@qq.com
 */
public class Notification {
    private String notificationId;

    private String notificationContent;

    private List<User> users;

    private String notificationDate;

    private String notificationTitle;

    private Integer notificationType;

    private Integer notificationState;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId == null ? null : notificationId.trim();
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent == null ? null : notificationContent.trim();
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate == null ? null : notificationDate.trim();
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle == null ? null : notificationTitle.trim();
    }

    public Integer getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(Integer notificationState) {
        this.notificationState = notificationState;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", notificationContent='" + notificationContent + '\'' +
                ", users=" + users +
                ", notificationDate='" + notificationDate + '\'' +
                ", notificationTitle='" + notificationTitle + '\'' +
                ", notificationType=" + notificationType +
                ", notificationState=" + notificationState +
                '}';
    }
}