package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.VehicleBaseMapper;
import com.yuan.foodtrace.auth.entity.VehicleRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

import static com.yuan.foodtrace.auth.dao.VehicleRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface VehicleMapper extends VehicleBaseMapper {

    default List<VehicleRecord> list() {
        return select(c -> c);
    }

    default List<VehicleRecord> listWithCompany(String _company) {
        return select(c ->
                c.where(company, isEqualTo(_company)));
    }

    default Optional<VehicleRecord> findByLicense(String _license) {
        return selectOne(c ->
                c.where(company, isEqualTo(_license)));
    }

}
