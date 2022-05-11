package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.FarmRecordDynamicSqlSupport;
import com.yuan.foodtrace.auth.dao.WorkerBaseMapper;
import com.yuan.foodtrace.auth.entity.WorkerRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

import static com.yuan.foodtrace.auth.dao.WorkerRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface WorkerMapper extends WorkerBaseMapper {

    default List<WorkerRecord> list() {
        return select(c -> c);
    }

    default List<WorkerRecord> listWithCompany(String _company) {
        return select(c ->
                c.where(company, isEqualTo(_company)));
    }

    default Optional<WorkerRecord> findByIdNumber(String _idNumber) {
        return selectOne(c ->
                c.where(idNumber, isEqualTo(_idNumber)));
    }

}
