package com.nnxy.competition.service.impl;

import com.nnxy.competition.dao.CompetitionTypeDao;
import com.nnxy.competition.entity.CompetitionType;
import com.nnxy.competition.service.CompetitionTypeService;
import com.nnxy.competition.utils.RedisUtil;
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
    private RedisUtil redisUtil;
    @Autowired
    private CompetitionTypeDao competitionTypeDao;

    @Override
    public List<CompetitionType> findAllCompetitionType() {
        List<CompetitionType> competitionTypes;
        if(redisUtil.hasKey("competitionTypes")) {
            competitionTypes = (List<CompetitionType>) redisUtil.get("competitionTypes");
            System.out.println("Redis缓存取出的竞赛类型");
        }
        else{
            competitionTypes = competitionTypeDao.findAllCompetitionType();
            redisUtil.set("competitionTypes",competitionTypes);
            System.out.println("数据库取出的竞赛类型");
        }
        return competitionTypes;
    }
}
