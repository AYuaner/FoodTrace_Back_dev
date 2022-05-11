package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.entity.Transportation;
import com.yuan.foodtrace.fabric.mapper.TransportationMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            info.setCreatedTime(time.format(formatter));
            return mapper.insert(info);
        }
        return false;
    }

    public List<Transportation> queryAll() {
        List<Transportation> transportations = mapper.queryAll();
        return transportations == null ? new ArrayList<>() : transportations;
    }
}
