package com.nnxy.competition.controller;

import com.nnxy.competition.entity.*;
import com.nnxy.competition.service.*;
import com.nnxy.competition.utils.CompetitionNotificationVO;
import com.nnxy.competition.utils.RedisUtil;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
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
 * 通知/通告/公告web层
 *
 * @author :CZS
 * @date :2019/12/18 10:14
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private CompetitionTypeService competitionTypeService;

    @Autowired
    private RedisUtil redisUtil;
    private String path = "C:\\Users\\Administrator\\Desktop\\file";

    /**
     * 通知类型查找通知，已指定notificationType为0的为竞赛通知
     *
     * @return
     */
    @RequestMapping("/findNotificationByType")
    public @ResponseBody
    ResponseMessage findNotificationByType() {
        try {
            //获取类型为0（竞赛通知）的数据
            List<Notification> notifications = notificationService.findNotificationByType(0);
            System.out.println(notifications);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("notifications", notifications);
            return responseMessage;
        } catch (Exception e) {
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 加载所有竞赛类型
     *
     * @return
     */
    @RequestMapping("/findAllType")
    public @ResponseBody
    ResponseMessage findAllType() {
        try {
            List<CompetitionType> competitionTypes = competitionTypeService.findAllCompetitionType();
            System.out.println(competitionTypes);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("competitionTypes", competitionTypes);
            return responseMessage;
        } catch (Exception e) {
            return new ResponseMessage("0", "获取失败");
        }
    }


    /**
     * 保存新竞赛，通知
     *
     * @param competitionNotificationVO
     * @return
     */
    @RequestMapping(value = "/insertCompetition", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage
    insertCompetitionNotification(@RequestBody CompetitionNotificationVO competitionNotificationVO) throws IOException {
        //封装比赛类
        Competition competition = new Competition();
        competition.setCompetitionContent(competitionNotificationVO.getCompetitionContent());
        competition.setCompetitionLevel(competitionNotificationVO.getCompetitionLevel());
        competition.setCompetitionSite(competitionNotificationVO.getCompetitionSite());
        competition.setCompetitionName(competitionNotificationVO.getCompetitionName());
        competition.setCompetitionType(competitionNotificationVO.getCompetitionType());
        competition.setCompetitionPeopleSum(competitionNotificationVO.getCompetitionPeopleSum());

        String competitionId = UUID.randomUUID().toString();
        //将competitionId存入redis，存储文件时使用
        redisUtil.set("competitionId", competitionId);
        //默认为比赛进行中
        competition.setCompetitionState(1);
        competition.setCompetitionId(competitionId);
        if (competitionNotificationVO.getCompetitionTime() == null || "".equals(competitionNotificationVO.getCompetitionTime()) || "待定".equals(competitionNotificationVO.getCompetitionTime())) {
            competition.setCompetitionTime("待定");
        } else {
            competition.setCompetitionTime(competitionNotificationVO.getCompetitionTime());
        }

        //若为院级比赛
        if (competition.getCompetitionLevel() == 1) {
            College college = new College();
            college.setCollegeId(competitionNotificationVO.getCollegeId());
            competition.setCollege(college);
        }

        //封装通知类
        Notification notification = new Notification();
        notification.setNotificationTitle(competitionNotificationVO.getNotificationTitle());
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setNotificationTime(System.currentTimeMillis());
        notification.setNotificationState(1);
        notification.setNotificationType(0);
        notification.setCompetition(competition);
        System.out.println(notification);
        System.out.println(competition);
        try {
            notificationService.insertCompetitionAndNotification(competition, notification);
            ResponseMessage responseMessage = new ResponseMessage("1", "添加成功");
            responseMessage.getData().put("competitionId", competition.getCompetitionId());
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "添加失败");
        }


    }

    /**
     * 根据通知id查找内容，用于回显修改通知的信息
     *
     * @param notificationId
     * @return
     */
    @RequestMapping("/findDataByNotificationId")
    public @ResponseBody
    ResponseMessage findDataByNotificationId(String notificationId) {
        try {
            Notification notification = notificationService.findDataByNotificationId(notificationId);
            List<File> files = fileService.findFileByCompetitionId(notification.getCompetition().getCompetitionId());
            notification.getCompetition().setFiles(files);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("notification", notification);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 根据通知id删除该竞赛通知及竞赛文件，比赛
     *
     * @param notificationId
     * @param competitionId
     * @return
     */
    @RequestMapping("/deleteByNotificationId")
    public @ResponseBody
    ResponseMessage deleteByNotificationId(String notificationId, String competitionId) {

        try {
            String s = null;
            List<File> files = fileService.findFileByCompetitionId(competitionId);
            //如果有文件
            if (files.size() > 0) {
                //保存文件夹路径
                s = files.get(0).getFilePath().substring(0, files.get(0).getFilePath().length() - files.get(0).getFileName().length() - 1);
                System.out.println(s);
                //快速for循环 快捷键iter
                for (File file : files) {
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
            }

            //删除信息
            notificationService.deleteNotificationById(notificationId, competitionId);
            ResponseMessage responseMessage = new ResponseMessage("1", "删除成功");
            return responseMessage;
        } catch (Exception e) {
            return new ResponseMessage("0", "删除失败");
        }
    }

    /**
     * 根据当前用户学校id查询学院列表，用于回显
     *
     * @return
     */
    @RequestMapping("/findCollege")
    public @ResponseBody
    ResponseMessage findCollege() {
        try {
            //获得当前用户（含用户名密码）
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            //根据用户名获得用户的学院id
            String collegeId = userService.findCollegeIdByUserName(user.getUserName());
            //根据学校id获得学院列表
            List<College> colleges = collegeService.findCollegeByUniversityId(collegeService.findCollegeById(collegeId).getUniversity().getUniversityId());
            System.out.println(colleges);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("colleges", colleges);
            return responseMessage;
        } catch (Exception e) {
            return new ResponseMessage("0", "获取失败");
        }
    }


    /**
     * 修改竞赛通知及竞赛文件，竞赛内容
     *
     * @param competitionNotificationVO
     * @return
     */
    @RequestMapping(value = "/updateNotification", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage updateNotification(@RequestBody CompetitionNotificationVO competitionNotificationVO) {
        //将competitionId存入redis，修改文件时使用
        redisUtil.set("competitionId", competitionNotificationVO.getCompetitionId());
        try {
            notificationService.updateNotification(competitionNotificationVO);
            ResponseMessage responseMessage = new ResponseMessage("1", "修改成功");
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "修改失败");
        }
    }
}
