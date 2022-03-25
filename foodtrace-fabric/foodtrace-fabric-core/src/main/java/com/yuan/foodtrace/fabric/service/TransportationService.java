package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.Transportation;
import com.yuan.foodtrace.fabric.mapper.TransportationMapper;
import org.springframework.stereotype.Service;

@Service
public class TransportationService {

    TransportationMapper mapper = new TransportationMapper();

    public Transportation queryById(String cropsId) {
        Transportation transportation = mapper.queryByPrimaryKey(cropsId);
        return transportation == null ? new Transportation() : transportation;
    }

    public boolean insert(Transportation info) {
        Transportation infoById = queryById(info.getCropsId());
        if (infoById.getCropsId() == null) {
            return mapper.insert(info);
        }
        return false;
    }
}
