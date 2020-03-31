package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.CompetitionService;
import com.nnxy.competition.service.TeamService;
import com.nnxy.competition.utils.POIUtils;
import com.nnxy.competition.utils.RedisUtil;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private TeamService teamService;
    @Autowired
    private RedisUtil redisUtil;
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

    /**
     * 获得该竞赛已报名的用户列表
     * @param competitionId
     * @return
     */
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
     * 获得所有比赛
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
     * 根据当前用户id获得已参加的竞赛列表
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
            redisUtil.set("competitionId", competitionId);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败");
        }
    }


    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<User> list = (List<User>) competitionService.findUserList(redisUtil.get("competitionId").toString());
        return POIUtils.userExcel(list);
    }

    @GetMapping("/exportTeam")
    public ResponseEntity<byte[]> exportTeamData() {
        //根据竞赛id及已报名的状态（3），获取队伍列表
        List<Team> teamList = teamService.findTeamByCompetitionIdAndRegistered(redisUtil.get("competitionId").toString());
        for (Team team : teamList) {
            //获取队伍成员放入队伍
            team.setUsers(teamService.findUserListByTeamIdAndCaptainId(team.getTeamId(),team.getCaptain().getUserId()));
        }
        return POIUtils.teamExcel(teamList);
    }

}
