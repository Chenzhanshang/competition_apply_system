package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Apply;
import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.TeamService;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/27 12:03
 * Email    :642125256@qq.com
 */

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    /**
     * 创建队伍
     * @param team
     * @return
     */
    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage addTeam(@RequestBody Team team){
        //生成id
        team.setTeamId(UUID.randomUUID().toString());
        //获得当前用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //设置队长为创建该队伍的当前用户
        team.setCaptain(user);
        //初始人数为1
        team.setTeamHeadcount(1);
        //初始状态为0（未满人，但不处于招募）
        team.setTeamState(0);
        try {
            teamService.insertTeam(team);
            return new ResponseMessage("1", "创建成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "创建失败");
        }
    }

    /**
     * 获取当前用户创建的所有队伍
     * @return
     */
    @RequestMapping("/findMyTeam")
    public @ResponseBody ResponseMessage findMyTeam(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            List<Team> teams = teamService.findMyTeam(user.getUserId());
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("teams", teams);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 获取当前用户加入的所有队伍
     * @return
     */
    @RequestMapping("/findJoinTeam")
    public @ResponseBody ResponseMessage findJoinTeam(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            List<Team> teams = teamService.findJoinTeam(user.getUserId());
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("teams", teams);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 根据队伍id获得队伍其他成员信息
     * @param teamId
     * @return
     */
    @RequestMapping("/findUsersByTeamId")
    public @ResponseBody ResponseMessage findUsersByTeamId(String teamId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            List<User> users = teamService.findUsersByTeamIdAndNotNowUser(teamId, user.getUserId());
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("users", users);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    /**
     * 根据队伍信息修改数据库队伍数据
     * @param team
     * @return
     */
    @RequestMapping(value = "/updateMyTeam")
    public @ResponseBody ResponseMessage updateMyTeam(@RequestBody Team team){
        try {
            teamService.updateMyTeam(team);
            return new ResponseMessage("1", "修改成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "修改失败");
        }
    }

    /**
     * 删除队伍中的成员
     * @param teamId
     * @param userId
     */
    @RequestMapping("/deleteTeamUser")
    public @ResponseBody ResponseMessage deleteTeamUser(String teamId, String userId){
        try {
            teamService.deleteTeamUser(teamId,userId);
            return new ResponseMessage("1", "删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "删除失败");
        }
    }

    /**
     * 解散队伍，并清空队员
     * @param teamId
     */
    @RequestMapping("/deleteTeam")
    public @ResponseBody ResponseMessage deleteTeam(String teamId){
        try {
            teamService.deleteTeam(teamId);
            return new ResponseMessage("1", "删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "删除失败");
        }
    }

    /**
     * 退出队伍
     * @param teamId
     * @return
     */
    @RequestMapping("/exitTeam")
    public @ResponseBody ResponseMessage exitTeam(String teamId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        try {
            teamService.deleteTeamOneUser(teamId, user.getUserId());
            return new ResponseMessage("1", "退出成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "退出失败");
        }
    }

    @RequestMapping("/joinMyTeamList")
    public @ResponseBody ResponseMessage joinMyTeamList(){
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            List<Team> teams = teamService.findMyTeam(user.getUserId());
            List<Apply> applies = teamService.findAllMyTeamApply(teams);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("applies", applies);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    @RequestMapping("/myDisposeList")
    public @ResponseBody ResponseMessage myDisposeList(){
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            List<Team> teams = teamService.findMyTeam(user.getUserId());
            List<Apply> applies = teamService.findAllMyHistoryTeamApply(teams);
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("applies", applies);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    @RequestMapping("/getMyTeamByCompetitionId")
    public @ResponseBody ResponseMessage getMyTeamByCompetitionId(String competitionId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            List<Team> teams = teamService.findMyTeam(user.getUserId());
            List<Team> teams1 = new ArrayList<Team>();
            if(teams.size() != 0 && teams != null){
                for (Team team : teams) {
                    if(team.getCompetition().getCompetitionId().equals(competitionId)){
                        teams1.add(team);
                    }
                }
            }
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("teams", teams1);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }

    }

}
