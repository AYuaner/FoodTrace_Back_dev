package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.FarmBaseMapper;
import com.yuan.foodtrace.auth.entity.FarmRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmMapper extends FarmBaseMapper {

    default List<FarmRecord> list() {
        return select(c -> c);
    }

}
