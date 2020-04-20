package com.nnxy.competition.service;

import com.nnxy.competition.entity.College;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/20 13:59
 * Email    :642125256@qq.com
 */
public interface CollegeService {

    /**
     * 根据学院名和用户所在学校查询学院
     *
     * @param collegeName
     * @param universityId
     * @return
     */
    College findCollegeByNameAndUniversityId(String collegeName, String universityId);

    /**
     * 根据id查询学院
     *
     * @param collegeId
     * @return
     */
    College findCollegeById(String collegeId);

    /**
     * 根据学校id查询学院列表
     *
     * @param universityId
     * @return
     */
    List<College> findCollegeByUniversityId(String universityId);
}
