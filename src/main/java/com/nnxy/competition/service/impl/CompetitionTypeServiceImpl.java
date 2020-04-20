package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.CompetitionTypeDao;
import com.nnxy.competition.entity.CompetitionType;
import com.nnxy.competition.service.CompetitionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :CZS
 * @date :2019/12/20 15:03
 * Email    :642125256@qq.com
 */
@Service
public class CompetitionTypeServiceImpl implements CompetitionTypeService {
    @Autowired
    private CompetitionTypeDao competitionTypeDao;

    @Override
    public List<CompetitionType> findAllCompetitionType() {
        List<CompetitionType> competitionTypes = competitionTypeDao.findAllCompetitionType();
        return competitionTypes;
    }
}
