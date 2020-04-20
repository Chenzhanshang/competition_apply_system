package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/22 17:30
 * Email    :642125256@qq.com
 */
@Mapper
public interface SystemNoticeDao {
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
     * 更新公告
     *
     * @param notification
     * @return
     */
    void updateNotification(Notification notification);
}
