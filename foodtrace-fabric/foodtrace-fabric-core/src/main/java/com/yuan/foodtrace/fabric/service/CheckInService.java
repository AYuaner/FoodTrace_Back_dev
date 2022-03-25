package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.CheckIn;
import com.yuan.foodtrace.fabric.mapper.CheckInMapper;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {

    CheckInMapper mapper = new CheckInMapper();

    public CheckIn queryById(String cropsId) {
        CheckIn checkIn = mapper.queryByPrimaryKey(cropsId);
        return checkIn == null ? new CheckIn() : checkIn;
    }

    public boolean insert(CheckIn info) {
        CheckIn infoById = queryById(info.getCropsId());
        if (infoById.getCropsId() == null) {
            return mapper.insert(info);
        }
        return false;
    }
}
