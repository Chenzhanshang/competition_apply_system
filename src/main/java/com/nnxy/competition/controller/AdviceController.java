package com.nnxy.competition.controller;

import com.nnxy.competition.entity.Advice;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.AdviceService;
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
 * 
 * @author  :CZS
 * @date    :2020/3/3 14:56
 * Email    :642125256@qq.com
 */
@Controller
@RequestMapping("/advice")
public class AdviceController {
    @Autowired
    private AdviceService adviceService;

    @RequestMapping(value = "/submitAdvice",method = RequestMethod.POST)
    public @ResponseBody
    ResponseMessage submitAdvice(@RequestBody Advice advice){

        advice.setUser((User)SecurityUtils.getSubject().getPrincipal());
        advice.setAdviceId(UUID.randomUUID().toString());
        advice.setAdviceDate(System.currentTimeMillis());
        //状态0未处理，1已处理
        advice.setAdviceState(0);
        System.out.println(advice);
        try {
            adviceService.insertAdvice(advice);
            return new ResponseMessage("1","提交成功！");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","提交失败！");
        }
    }

    @RequestMapping(value = "/getAllAdvice",method = RequestMethod.GET)
    public @ResponseBody
    ResponseMessage getAllAdvice(Integer adviceState){
        System.out.println(adviceState);
        try {
            List<Advice> advices = adviceService.getAllAdvice(adviceState);
            ResponseMessage responseMessage = new ResponseMessage("1","获取成功！");
            responseMessage.getData().put("advices",advices);
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","获取失败！");
        }
    }

    @RequestMapping("/disposeAdvice")
    public @ResponseBody ResponseMessage disposeAdvice(String adviceId){
        Advice advice = new Advice();
        advice.setAdviceId(adviceId);
        advice.setDisposeTime(System.currentTimeMillis());
        advice.setAdviceState(1);
        try {
            adviceService.updateAdvice(advice);
            return new ResponseMessage("1","处理成功，可到反馈建议管理->已处理反馈 查看");
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage("0","处理失败");
        }
    }
}
