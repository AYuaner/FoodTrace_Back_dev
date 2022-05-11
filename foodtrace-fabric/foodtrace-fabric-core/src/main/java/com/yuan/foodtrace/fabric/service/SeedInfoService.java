package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.mapper.SeedInfoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            info.setCreatedTime(time.format(formatter));
            return mapper.insert(info);
        }
        return false;
    }

    public List<SeedInfo> queryAll() {
        List<SeedInfo> seedInfos = mapper.queryAll();
        return seedInfos == null ? new ArrayList<>() : seedInfos;
    }
}
