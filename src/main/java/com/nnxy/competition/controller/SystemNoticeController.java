package com.nnxy.competition.controller;

import com.nnxy.competition.entity.File;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.service.FileService;
import com.nnxy.competition.service.SystemNoticeService;
import com.nnxy.competition.utils.RedisUtil;
import com.nnxy.competition.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 系统公告web层
 * @author  :CZS
 * @date    :2019/12/22 17:16
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/notice")
public class SystemNoticeController {

    @Autowired
    private SystemNoticeService systemNoticeService;
    @Autowired
    private FileService fileService;

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 已指定notificationType为1的为系统通知
     * @return
     */
    @RequestMapping("/findAll")
    public @ResponseBody
    ResponseMessage findNotice(){
        try{
            List<Notification> notifications = systemNoticeService.findNoticeByType(1);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("notifications",notifications);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }

    }

    /**
     * 保存新公告
     * @param notification
     * @return
     */
    @RequestMapping(value = "/insertNotice", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage
    insertNotice(@RequestBody Notification notification) throws IOException {
        //生成id
        notification.setNotificationId(UUID.randomUUID().toString());
        //将notificationId存入redis，存储文件时使用
        redisUtil.set("notificationId",notification.getNotificationId());
        //获得当前毫秒值作为公告时间
        notification.setNotificationTime(System.currentTimeMillis());

        //设置类型为1（即系统公告）
        notification.setNotificationType(1);

        System.out.println(notification);
        try {
            systemNoticeService.insertNotice( notification);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "添加失败");
        }
        return new ResponseMessage("1", "添加成功");

    }

    /**
     * 删除公告
     * @param notificationId
     * @return
     */
    @RequestMapping("/deleteNotice")
    public @ResponseBody
    ResponseMessage
    deleteNoticeById(String notificationId) throws IOException {
        try {
            String s = null;
            List<File> files = fileService.findFileByNotificationId(notificationId);
            //如果有文件
            if(files.size() > 0){
                //截取文件保存所在的文件夹路径
                s = files.get(0).getFilePath().substring(0,files.get(0).getFilePath().length() - files.get(0).getFileName().length() - 1);
                System.out.println(s);
                //快速for循环 快捷键iter
                for (File file : files) {
                    System.out.println(file);
                    java.io.File f = new java.io.File(file.getFilePath());
                    //文件是否存在
                    if (f.exists()) {
                        //存在就删除
                        if (f.delete()) {
                            System.out.println("本地文件删除成功");
                        } else {
                            System.out.println("本地文件删除失败");
                        }
                    } else {
                        System.out.println("本地不存在");
                    }
                }
                //获得上级文件夹
                java.io.File f1 = new java.io.File(s);
                //删除文件夹
                f1.delete();
                //删除信息
            }

            systemNoticeService.deleteNotificationById(notificationId);
            ResponseMessage responseMessage = new ResponseMessage("1", "删除成功");
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "删除失败");
        }
    }

    /**
     * 修改公告内容
     * @param notification
     * @return
     */
    @RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updateNotification(@RequestBody Notification notification){
        System.out.println(notification);
        //将competitionId存入redis，修改文件时使用
        redisUtil.set("notificationId",notification.getNotificationId());
        try {
            systemNoticeService.updateNotification(notification);
            ResponseMessage responseMessage = new ResponseMessage("1","修改成功");
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","修改失败");
        }
    }
}
