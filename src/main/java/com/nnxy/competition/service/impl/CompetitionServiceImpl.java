package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.CompetitionDao;
import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author  :CZS
 * @date    :2019/12/18 15:27
 * Email    :642125256@qq.com
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    private  CompetitionDao competitionDao;

    @Override
    public Competition findCompetitionById(String competitionId) {
        Competition competition = competitionDao.findCompetitionById(competitionId);
        return competition;
    }

}
