package com.nnxy.competition.service;

import com.nnxy.competition.entity.Advice;

import java.util.List;

/**
 * @author :CZS
 * @date :2020/3/3 15:09
 * Email    :642125256@qq.com
 */

public interface AdviceService {
    /**
     * 插入反馈建议
     *
     * @param advice
     */
    public void insertAdvice(Advice advice);

    /**
     * 获取所有的投诉建议
     *
     * @param adviceState
     * @return
     */
    List<Advice> getAllAdvice(Integer adviceState);

    /**
     * 更新处理后的建议信息
     *
     * @param advice
     */
    void updateAdvice(Advice advice);
}
