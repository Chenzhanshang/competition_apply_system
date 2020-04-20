package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.UniversityDao;
import com.nnxy.competition.entity.University;
import com.nnxy.competition.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :CZS
 * @date :2019/12/20 14:08
 * Email    :642125256@qq.com
 */
@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    private UniversityDao universityDao;

    @Override
    public University findUniversityByCollegeId(String collegeId) {
        University university = universityDao.findUniversityByCollegeId(collegeId);
        return university;
    }
}
