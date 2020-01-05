package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Team;
import com.nnxy.competition.service.RecruitService;
import com.nnxy.competition.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            ResponseMessage responseMessage = new ResponseMessage("1", "获取成功");
            responseMessage.getData().put("teams", teams);
            return responseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("0", "获取失败");
        }
    }
}
