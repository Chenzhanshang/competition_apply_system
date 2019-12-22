package com.nnxy.competition.controller;

import com.nnxy.competition.entity.User;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.ApplyService;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 16:40
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @RequestMapping("/doApply")
    public @ResponseBody
    ResponseMessage doApply(String competitionId){
        System.out.println(competitionId);
        //创建中间表对象，封装报名信息
        UserCompetition userCompetition = new UserCompetition();
        userCompetition.setCompetitionId(competitionId);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        userCompetition.setUserId(user.getUserId());
        //获取当前时间毫秒值,并存入封装对象
        userCompetition.setDate(System.currentTimeMillis());
        try{
            applyService.insertApply(userCompetition);
            return new ResponseMessage("1", "报名成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "报名失败");
        }

    }

    @RequestMapping("/cancelApply")
    public @ResponseBody
    ResponseMessage cancelApply(String competitionId){
        //创建中间表对象，封装报名信息
        UserCompetition userCompetition = new UserCompetition();
        userCompetition.setCompetitionId(competitionId);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        userCompetition.setUserId(user.getUserId());
        try{
            applyService.deleteApply(userCompetition);
            return new ResponseMessage("1", "取消报名成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "取消报名失败");
        }

    }

    @RequestMapping("/loadApplyState")
    public @ResponseBody
    ResponseMessage loadApplyState(String competitionId){
        System.out.println(competitionId);
        //创建中间表对象，封装报名信息
        UserCompetition userCompetition = new UserCompetition();
        userCompetition.setCompetitionId(competitionId);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        userCompetition.setUserId(user.getUserId());

        try{
            UserCompetition uc = applyService.findApplyByUserIdAndCompetitionId(userCompetition);
            ResponseMessage responseMessage = new ResponseMessage("1", "加载成功");
            responseMessage.getData().put("userCompetition",uc);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "加载失败");
        }

    }

}
