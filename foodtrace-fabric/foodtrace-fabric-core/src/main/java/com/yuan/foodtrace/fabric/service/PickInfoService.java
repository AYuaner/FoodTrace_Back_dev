package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.PickInfo;
import com.yuan.foodtrace.fabric.mapper.PickInfoMapper;
import org.springframework.stereotype.Service;

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
            return mapper.insert(info);
        }
        return false;
    }
}