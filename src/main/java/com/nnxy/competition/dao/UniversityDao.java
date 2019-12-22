package com.nnxy.competition.dao;

import com.nnxy.competition.entity.University;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :CZS
 * @date :2019/12/20 14:05
 * Email    :642125256@qq.com
 */
@Mapper
public interface UniversityDao {
    /**
     * 根据用户的学院id查询学校
     * @param collegeId
     * @return
     */
    University findUniversityByCollegeId(String collegeId);
}
