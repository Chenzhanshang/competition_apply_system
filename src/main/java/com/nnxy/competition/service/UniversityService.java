package com.nnxy.competition.service;

import com.nnxy.competition.entity.University;

/**
 * @author :CZS
 * @date :2019/12/20 14:08
 * Email    :642125256@qq.com
 */
public interface UniversityService {
    /**
     * 根据用户的学院id查询学校
     *
     * @param collegeId
     * @return
     */
    University findUniversityByCollegeId(String collegeId);
}
