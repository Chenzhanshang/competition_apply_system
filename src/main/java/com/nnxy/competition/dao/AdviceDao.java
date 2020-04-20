package com.nnxy.competition.dao;

import com.nnxy.competition.entity.Advice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author :CZS
 * @date :2020/3/3 15:11
 * Email    :642125256@qq.com
 */
@Mapper
public interface AdviceDao {
    /**
     * 插入反馈建议
     *
     * @param advice
     */
    public void insertAdvice(Advice advice);

    /**
     * 获取所有的投诉建议
     *
     * @return
     */
    List<Advice> getAllAdvice(Integer adviceState);

    /**
     * 插入反馈建议
     *
     * @param advice
     */
    void updateAdvice(Advice advice);
}
