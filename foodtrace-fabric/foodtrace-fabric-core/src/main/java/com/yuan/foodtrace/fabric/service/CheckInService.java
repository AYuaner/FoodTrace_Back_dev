package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.CheckIn;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.mapper.CheckInMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            info.setCreatedTime(time.format(formatter));
            return mapper.insert(info);
        }
        return false;
    }

    public List<CheckIn> queryAll() {
        List<CheckIn> checkIns = mapper.queryAll();
        return checkIns == null ? new ArrayList<>() : checkIns;
    }
}
