package com.nnxy.competition.controller;

import com.nnxy.competition.entity.File;
import com.nnxy.competition.entity.Notification;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.ApplyService;
import com.nnxy.competition.service.FileService;
import com.nnxy.competition.service.WinNotificationService;
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
 * 
 * @author  :CZS
 * @date    :2019/12/24 14:23
 * Email    :642125256@qq.com
 */

@Controller
@RequestMapping("/win")
public class WinNotificationController {
    @Autowired
    private WinNotificationService winNotificationService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private FileService fileService;
    /**
     * 获取所有获奖通知
     * @return
     */
    @RequestMapping("/findAllWinNotification")
    public @ResponseBody
    ResponseMessage findAllWinNotification(){
        try {
            List<Notification> notifications = winNotificationService.findAllWinNotification(2);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("notifications", notifications);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    @RequestMapping("/findWinByCompetitionId")
    public @ResponseBody ResponseMessage findWinByCompetitionId(String competitionId){
        try {
            List<UserCompetition> userCompetitions = applyService.findWinByCompetitionId(competitionId);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("userCompetitions",userCompetitions);
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
    @RequestMapping(value = "/insertWinNotification", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage
    insertWinNotification(@RequestBody Notification notification) throws IOException {
        //生成id
        notification.setNotificationId(UUID.randomUUID().toString());
        //判断是否为上传文件的获奖通知
        if(notification.getUserIds() == null || notification.getUserIds().size() == 0){
            //将notificationId存入redis，存储文件时使用
            redisUtil.set("notificationId",notification.getNotificationId());
        }
        //获得当前毫秒值作为通知时间
        notification.setNotificationTime(System.currentTimeMillis());
        //设置类型为2（即获奖通知）
        notification.setNotificationType(2);
        try {
            winNotificationService.insertWinNotification(notification);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "添加失败");
        }
        return new ResponseMessage("1", "添加成功");

    }

    /**
     * 删除获奖通知
     * @param notificationId
     * @return
     */
    @RequestMapping("/deleteWinNotification")
    public @ResponseBody
    ResponseMessage
    deleteWinNotificationById(String notificationId, String competitionId) throws IOException {
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
            winNotificationService.deleteWinNotificationById(notificationId, competitionId);
            ResponseMessage responseMessage = new ResponseMessage("1", "删除成功");
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "删除失败");
        }
    }

    /**
     * 获取回显表单数据
     * @param competitionId
     * @param notificationId
     * @return
     */
    @RequestMapping("/findWinForm")
    public @ResponseBody ResponseMessage findWinForm(String notificationId, String competitionId){
        try {
            List<UserCompetition> userCompetitions = applyService.findWinByCompetitionId(competitionId);
            List<File> files = fileService.findFileByNotificationId(notificationId);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("userCompetitions", userCompetitions);
            responseMessage.getData().put("files", files);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 更新公告
     * @param notification
     * @return
     */
    @RequestMapping(value = "/updateWinNotification", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage
    updateWinNotification(@RequestBody Notification notification) throws IOException {
        //判断是否为上传文件的获奖通知
        if(notification.getUserIds() == null || notification.getUserIds().size() == 0){
            //将notificationId存入redis，存储文件时使用
            redisUtil.set("notificationId",notification.getNotificationId());
        }
        System.out.println(notification);
        try {
            winNotificationService.updateWinNotification(notification);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "修改失败");
        }
        return new ResponseMessage("1", "修改成功");

    }

}
