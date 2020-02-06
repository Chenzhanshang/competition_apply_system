package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.entity.UserTeam;
import com.nnxy.competition.service.RecruitService;
import com.nnxy.competition.service.TeamService;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 招募web层
 * @author  :CZS
 * @date    :2019/12/30 11:31
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private TeamService teamService;

    /**
     * 根据队伍状态获取正在招募的队伍列表
     * @return
     */
    @RequestMapping("/findAllRecruitTeam")
    public @ResponseBody
    ResponseMessage findAllRecruitTeam() {
        try {
            //队伍状态为1的为未满员，正在招募
            List<Team> teams = recruitService.findAllTeamByState(1);
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            List<UserTeam> userTeams = recruitService.findAllUserTeam(user.getUserId());
            //存放未加入且正在招募的队伍
            List<Team> teams1 = new ArrayList<Team>();
            int i;
            for (Team team : teams) {
                for (i = 0; i < userTeams.size(); i++ ) {
                    if(team.getTeamId().equals(userTeams.get(i).getTeamId())){
                        break;
                    }
                }
                if(i == userTeams.size()){
                    teams1.add(team);
                }

            }
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("teams", teams1);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }

    @RequestMapping("/recruitUser")
    public @ResponseBody ResponseMessage recruitUser(String teamId){
        Team team = new Team();
        team.setTeamId(teamId);
        //设置队伍状态为1,即招募中
        team.setTeamState(1);
        try {
            teamService.updateTeam(team);
            return new ResponseMessage("1","发起招募成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","发起招募失败");
        }

    }

    @RequestMapping("/cancelRecruit")
    public @ResponseBody ResponseMessage cancelRecruit(String teamId){
        Team team = new Team();
        team.setTeamId(teamId);
        //设置队伍状态为0,即未招募
        team.setTeamState(0);
        try {
            teamService.updateTeam(team);
            return new ResponseMessage("1","取消招募成功");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","取消招募失败");
        }

    }
}
