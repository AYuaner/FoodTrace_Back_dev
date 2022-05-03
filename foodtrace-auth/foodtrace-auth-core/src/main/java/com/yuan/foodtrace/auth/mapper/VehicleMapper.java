package com.yuan.foodtrace.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleMapper extends VehicleBaseMapper {

    default List<VehicleRecord> list() {
        return select(c -> c);
    }

}
