package com.nnxy.competition.controller;

import com.nnxy.competition.entity.*;
import com.nnxy.competition.service.ApplyService;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * 报名，申请web层
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
        Competition competition = new Competition();
        competition.setCompetitionId(competitionId);
        userCompetition.setCompetition(competition);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        userCompetition.setUser(user);
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
        Competition competition = new Competition();
        competition.setCompetitionId(competitionId);
        userCompetition.setCompetition(competition);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        userCompetition.setUser(user);
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
        Competition competition = new Competition();
        competition.setCompetitionId(competitionId);
        userCompetition.setCompetition(competition);
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        userCompetition.setUser(user);

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

    @RequestMapping(value = "/joinTeam", method = RequestMethod.POST)
    public @ResponseBody ResponseMessage joinTeam(@RequestBody Apply apply){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        apply.setUser(user);
        apply.setApplyId(UUID.randomUUID().toString());
        apply.setApplyTime(System.currentTimeMillis());
        apply.setApplyState(0);
        try {
            applyService.insertTeamApply(apply);
            ResponseMessage responseMessage = new ResponseMessage("1", "提交申请成功");
            return responseMessage;
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "提交失败");
        }
    }

    /**
     * 通过加入队伍申请
     * @param applyId
     * @return
     */
    @RequestMapping("/pass")
    public @ResponseBody ResponseMessage pass(String applyId){
        Apply apply = new Apply();
        apply.setApplyId(applyId);
        apply.setApplyDisposeTime(System.currentTimeMillis());
        apply.setApplyState(1);
        try {
            applyService.updateApplyByDispose(apply);
            return new ResponseMessage("1", "处理成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "处理失败");
        }
    }

    /**
     * 拒绝加入队伍申请
     * @param applyId
     * @return
     */
    @RequestMapping("/refuse")
    public @ResponseBody ResponseMessage refuse(String applyId){
        Apply apply = new Apply();
        apply.setApplyId(applyId);
        apply.setApplyDisposeTime(System.currentTimeMillis());
        apply.setApplyState(2);
        try {
            applyService.updateApplyByDispose(apply);
            return new ResponseMessage("1", "处理成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "处理失败");
        }
    }

    /**
     * 获取用户正在申请的申请列表
     * @return
     */
    @RequestMapping("/getMyJoinApplyList")
    public @ResponseBody ResponseMessage getMyJoinApplyList(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            List<Apply> applies = applyService.findMyApplyList(user.getUserId(), 0);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("applies", applies);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 获取用户已结束的申请列表
     * @return
     */
    @RequestMapping("/getHistoryJoinApplyList")
    public @ResponseBody ResponseMessage getHistoryJoinApplyList(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            //除状态0以外都是已结束的申请
            List<Apply> applies = applyService.findMyHistoryApplyList(user.getUserId(), 0);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("applies", applies);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

}
