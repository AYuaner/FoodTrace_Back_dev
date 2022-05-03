package com.yuan.foodtrace.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmMapper extends FarmBaseMapper {

    default List<FarmRecord> list() {
        return select(c -> c);
    }

}
