package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.PickInfo;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.mapper.PickInfoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PickInfoService {

    PickInfoMapper mapper = new PickInfoMapper();

    public PickInfo queryById(String cropsId) {
        PickInfo pickInfo = mapper.queryByPrimaryKey(cropsId);
        return pickInfo == null ? new PickInfo() : pickInfo;
    }

    public boolean insert(PickInfo info) {
        PickInfo infoById = queryById(info.getCropsId());
        if (infoById.getCropsId() == null) {
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            info.setCreatedTime(time.format(formatter));
            return mapper.insert(info);
        }
        return false;
    }

    public List<PickInfo> queryAll() {
        List<PickInfo> pickInfos = mapper.queryAll();
        return pickInfos == null ? new ArrayList<>() : pickInfos;
    }
}
