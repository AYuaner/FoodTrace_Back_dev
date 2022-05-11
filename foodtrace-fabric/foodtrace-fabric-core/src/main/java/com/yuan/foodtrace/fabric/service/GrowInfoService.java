package com.yuan.foodtrace.fabric.service;

import com.yuan.foodtrace.fabric.entity.GrowInfo;
import com.yuan.foodtrace.fabric.mapper.GrowInfoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            info.setCreatedTime(time.format(formatter));
            return mapper.insert(info);
        }
        return false;
    }

    public List<GrowInfo> queryAll() {
        List<GrowInfo> growInfos = mapper.queryAll();
        return growInfos == null ? new ArrayList<>() : growInfos;
    }

    public List<GrowInfo> queryByCropsId(String cropsId) {
        List<GrowInfo> growInfos = mapper.queryByCropsId(cropsId);
        return growInfos == null ? new ArrayList<>() : growInfos;
    }

    public int getCount() {
        return mapper.count();
    }
}
