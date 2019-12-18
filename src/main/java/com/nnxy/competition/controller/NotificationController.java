package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.service.NotificationService;
import com.nnxy.competition.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  通知/通告/公告web层
 * @author  :CZS
 * @date    :2019/12/18 10:14
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;


    /**
     * 通知类型查找通知
     * @param notificationType
     * @return
     */
    @RequestMapping("/findNotificationByType")
    public @ResponseBody
    ResponseMessage findNotificationByType(Integer notificationType){
        try{
            List<Notification> notifications = notificationService.findNotificationByType(notificationType);
            System.out.println(notifications);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("notifications",notifications);
            return responseMessage;
        }
        catch (Exception e){
            return new ResponseMessage("0","获取失败");
        }


    }
}
