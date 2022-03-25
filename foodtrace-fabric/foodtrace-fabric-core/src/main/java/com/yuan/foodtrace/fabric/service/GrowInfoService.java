package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.GrowInfo;
import com.yuan.foodtrace.fabric.mapper.GrowInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class GrowInfoService {

    GrowInfoMapper mapper = new GrowInfoMapper();

    public GrowInfo queryByOperaId(String operaId) {
        GrowInfo growInfo = mapper.queryByPrimaryKey(operaId);
        return growInfo == null ? new GrowInfo() : growInfo;
    }

    public boolean insert(GrowInfo info) {
        GrowInfo infoById = queryByOperaId(info.getOperationId());
        if (infoById.getOperationId() == null) {
            return mapper.insert(info);
        }
        return false;
    }
}
