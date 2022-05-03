package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.dto.VehicleDTO;
import com.yuan.foodtrace.auth.mapper.VehicleMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleMapper mapper;

    public List<VehicleRecord> list() {
        return mapper.list();
    }

    public boolean insert(VehicleDTO dto) {
        VehicleRecord vehicleById = mapper.selectByPrimaryKey(dto.getId()).orElse(new VehicleRecord());

        if (vehicleById.getId() == null) {
            VehicleRecord vehicleRecord = MapperUtils.VehicleDTOToEntity(dto);
            return mapper.insertSelective(vehicleRecord) == 0 ? false : true;
        }
        return false;
    }

    public boolean delete(VehicleDTO dto) {
        mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("this id do not match vehicle"));
        return mapper.deleteByPrimaryKey(dto.getId()) == 0 ? false : true;
    }

    public boolean update(VehicleDTO dto) {
        mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("this id do not match vehicle"));
        VehicleRecord vehicleRecord = MapperUtils.VehicleDTOToEntity(dto);
        return mapper.updateByPrimaryKeySelective(vehicleRecord) == 0 ? false : true;
    }

    public VehicleRecord queryOne(VehicleDTO dto) {
        if (StringUtils.isEmpty(dto.getId())) {
            throw new RuntimeException("PrimaryKey(id) is Empty");
        }
        return mapper.selectByPrimaryKey(dto.getId()).orElseThrow(() -> new RuntimeException("this id do not match vehicle"));
    }
}
