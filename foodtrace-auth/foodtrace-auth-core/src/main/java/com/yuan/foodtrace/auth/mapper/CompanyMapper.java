package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.CompanyBaseMapper;
import com.yuan.foodtrace.auth.entity.CompanyRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper extends CompanyBaseMapper {

    default List<CompanyRecord> list() {
        return select(c -> c);
    }
}
