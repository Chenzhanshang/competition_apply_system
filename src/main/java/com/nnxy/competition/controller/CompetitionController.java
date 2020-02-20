package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.CompetitionService;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 15:23
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    /**
     * 根据比赛id获得比赛
     * @param competitionId
     * @return
     */
    @RequestMapping("/findCompetitionById")
    public @ResponseBody
    ResponseMessage findCompetitionById(String competitionId){
        System.out.println(competitionId);
        try {
            Competition competition = competitionService.findCompetitionById(competitionId);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("competition", competition);
            System.out.println(competition);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

    @RequestMapping("/findUserByCompetitionId")
    public @ResponseBody ResponseMessage findUserByCompetitionId(String competitionId){
        try {
            List<User> users = competitionService.findUserByCompetitionId(competitionId);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("users", users);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 查询所有比赛
     * @return
     */
    @RequestMapping("/findAllCompetition")
    public @ResponseBody
    ResponseMessage findAllCompetition(){
        try{
            List<Competition> competitions = competitionService.findAllCompetition();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("competitions", competitions);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 根据当前用户id获得已参加列表
     * @return
     */
    @RequestMapping("/findCompetitionListByUserId")
    public @ResponseBody ResponseMessage findCompetitionListByUserId(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        try {
            List<UserCompetition> userCompetitions = competitionService.findCompetitionListByUserId(user.getUserId());
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("userCompetitions", userCompetitions);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 查询所有组队比赛
     * @return
     */
    @RequestMapping("/findAllTeamCompetition")
    public @ResponseBody
    ResponseMessage findAllTeamCompetition(){
        try{
            List<Competition> competitions = competitionService.findAllTeamCompetition();
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("competitions", competitions);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 通过竞赛id,查询报名该竞赛的用户列表
     * @param competitionId
     * @return
     */
    @RequestMapping("/getUserReportList")
    public @ResponseBody ResponseMessage getUserReportList(String competitionId){
        try {
            List<User> users = competitionService.findUserList(competitionId);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功");
            responseMessage.getData().put("users", users);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }

}
