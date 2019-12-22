package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.CollegeDao;
import com.nnxy.competition.entity.College;
import com.nnxy.competition.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/20 14:00
 * Email    :642125256@qq.com
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeDao collegeDao;
    @Override
    public College findCollegeByNameAndUniversityId(String collegeName, String universityId) {
        College college = collegeDao.findCollegeByNameAndUniversityId(collegeName, universityId);
        return college;
    }

    @Override
    public College findCollegeById(String collegeId) {
        College college = collegeDao.findCollegeById(collegeId);
        return college;
    }

    @Override
    public List<College> findCollegeByUniversityId(String universityId) {
        List<College> colleges = collegeDao.findCollegeByUniversityId(universityId);
        return colleges;
    }
}
