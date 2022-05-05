package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.FarmBaseMapper;
import com.yuan.foodtrace.auth.entity.FarmRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

import static com.yuan.foodtrace.auth.dao.FarmRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface FarmMapper extends FarmBaseMapper {

    default List<FarmRecord> list(String _company) {
        return select(c ->
                c.where(company, isEqualTo(_company)));
    }

    default Optional<FarmRecord> findByName(String _name) {
        return selectOne(c ->
                c.where(name, isEqualTo(_name)));
    }

}
