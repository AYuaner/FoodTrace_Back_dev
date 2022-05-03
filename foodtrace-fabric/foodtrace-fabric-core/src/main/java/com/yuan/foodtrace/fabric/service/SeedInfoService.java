package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.mapper.SeedInfoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeedInfoService {

    SeedInfoMapper mapper = new SeedInfoMapper();

    public SeedInfo queryByCropsId(String cropsId) {
        SeedInfo seedInfo = mapper.queryByPrimaryKey(cropsId);
        return seedInfo == null ? new SeedInfo() : seedInfo;
    }

    public boolean insert(SeedInfo info) {
        SeedInfo infoById = queryByCropsId(info.getCropsId());
        if (infoById.getCropsId() == null) {
            LocalDateTime time = LocalDateTime.now();
            info.setCreatedTime(time.toString());
            return mapper.insert(info);
        }
        return false;
    }

    public List<SeedInfo> queryAll() {
        List<SeedInfo> seedInfos = mapper.queryAll();
        return seedInfos == null ? new ArrayList<>() : seedInfos;
    }
}
