package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.service.CompetitionService;
import com.nnxy.competition.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            return new ResponseMessage("0","获取失败");
        }
    }


}
