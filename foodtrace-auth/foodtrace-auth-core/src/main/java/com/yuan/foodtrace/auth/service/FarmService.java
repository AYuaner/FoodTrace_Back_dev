package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.dto.FarmDTO;
import com.yuan.foodtrace.auth.mapper.FarmMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    @Autowired
    FarmMapper mapper;

    public List<FarmRecord> list() {
        return mapper.list();
    }

    public boolean insert(FarmDTO dto) {
        FarmRecord recordById = mapper.selectByPrimaryKey(dto.getId()).orElse(new FarmRecord());

        if (recordById.getId() == null) {
            FarmRecord farmRecord = MapperUtils.FarmDTOToEntity(dto);
            return mapper.insertSelective(farmRecord) == 0 ? false : true;
        }
        return false;
    }

    public boolean delete(FarmDTO dto) {
        mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("该id农场不存在"));
        return mapper.deleteByPrimaryKey(dto.getId()) == 0 ? false : true;
    }

    public boolean update(FarmDTO dto) {
        mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("该id农场不存在"));
        FarmRecord farmRecord = MapperUtils.FarmDTOToEntity(dto);
        return mapper.updateByPrimaryKeySelective(farmRecord) == 0 ? false : true;
    }

    public FarmRecord queryOne(FarmDTO dto) {
        if (StringUtils.isEmpty(dto.getId())) {
            throw new RuntimeException("PrimaryKey is Empty");
        }
        return mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("该id农场不存在"));
    }
}
