package com.tensquare.gathering.service;


import com.tensquare.gathering.dao.GatheringDao;
import com.tensquare.gathering.entity.Gathering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 服务层
 *
 * @author Administrator
 */
@Service
public class GatheringService {
    @Autowired
    private GatheringDao gatheringDao;


    public List<Gathering> getgatheringList() {
        return gatheringDao.getGatheringList();
    }

    public Gathering getGathering(Gathering gathering) {
        Gathering gathering1 = null;
        if (!(Objects.isNull(gathering.getId()) && Objects.isNull(gathering.getName()))) {
            gathering1 = gatheringDao.getGathering(gathering);
        }
        return gathering1;
    }

    public List<Gathering> findByName(Gathering gathering) {
        List<Gathering> List = null;
        if (!(Objects.isNull(gathering.getName()))) {
            List = gatheringDao.getByName(gathering);
        }
        return List;
    }

    public Boolean updateById(Gathering gathering) {
        boolean flag = false;
        if (!(Objects.isNull(gathering.getId()))) {
            flag = gatheringDao.updategathering(gathering);
        }
        return flag;
    }
}
