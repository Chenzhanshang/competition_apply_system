package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.CompetitionDao;
import com.nnxy.competition.dao.FileDao;
import com.nnxy.competition.entity.Competition;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.entity.UserCompetition;
import com.nnxy.competition.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private FileDao fileDao;

    @Override
    public Competition findCompetitionById(String competitionId) {
        Competition competition = competitionDao.findCompetitionById(competitionId);
//        List<File> files = fileDao.findFileByCompetitionId(competitionId);
//        competition.setFiles(files);
        return competition;
    }

    @Override
    public List<Competition> findAllCompetition() {
        List<Competition> competitions = competitionDao.findAllCompetition();
        return competitions;
    }

    @Override
    public List<User> findUserByCompetitionId(String competitionId) {
        List<User> users = competitionDao.findUserByCompetitionId(competitionId);
        return users;
    }

    @Override
    public List<UserCompetition> findCompetitionListByUserId(String userId) {
        List<UserCompetition> competitions = competitionDao.findCompetitionListByUserId(userId);
        return competitions;
    }

    @Override
    public List<Competition> findAllTeamCompetition() {
        List<Competition> competitions = competitionDao.findAllTeamCompetition();
        return competitions;
    }

}
