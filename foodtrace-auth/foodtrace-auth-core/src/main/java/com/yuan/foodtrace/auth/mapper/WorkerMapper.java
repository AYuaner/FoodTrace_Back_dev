package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.WorkerBaseMapper;
import com.yuan.foodtrace.auth.entity.WorkerRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerMapper extends WorkerBaseMapper {

    default List<WorkerRecord> list() {
        return select(c -> c);
    }

}
