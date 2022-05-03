package com.yuan.foodtrace.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerMapper extends WorkerBaseMapper {

    default List<WorkerRecord> list() {
        return select(c -> c);
    }

}
