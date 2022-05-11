package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.CompanyBaseMapper;
import com.yuan.foodtrace.auth.entity.CompanyRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

import static com.yuan.foodtrace.auth.dao.CompanyRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface CompanyMapper extends CompanyBaseMapper {

    default List<CompanyRecord> list() {
        return select(c -> c);
    }

    default Optional<CompanyRecord> findByName(String _name) {
        return selectOne(c ->
                c.where(name, isEqualTo(_name)));
    }

}
