package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 10:30
 * Email    :642125256@qq.com
 */
@Mapper
public interface NotificationDao {
    /**
     * 通知类型查找通知
     * @param notificationType
     * @return
     */
    public List<Notification> findNotificationByType(Integer notificationType) ;
}
