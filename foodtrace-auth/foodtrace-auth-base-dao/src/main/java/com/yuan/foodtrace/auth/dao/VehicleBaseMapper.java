package com.yuan.foodtrace.auth.dao;

import static com.yuan.foodtrace.auth.dao.VehicleRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.yuan.foodtrace.auth.entity.VehicleRecord;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface VehicleBaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    BasicColumn[] selectList = BasicColumn.columnList(id, brand, type, buyYear, license, company);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<VehicleRecord> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<VehicleRecord> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("VehicleRecordResult")
    Optional<VehicleRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="VehicleRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_year", property="buyYear", jdbcType=JdbcType.VARCHAR),
        @Result(column="license", property="license", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR)
    })
    List<VehicleRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, vehicleRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, vehicleRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int insert(VehicleRecord record) {
        return MyBatis3Utils.insert(this::insert, record, vehicleRecord, c ->
            c.map(id).toProperty("id")
            .map(brand).toProperty("brand")
            .map(type).toProperty("type")
            .map(buyYear).toProperty("buyYear")
            .map(license).toProperty("license")
            .map(company).toProperty("company")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int insertMultiple(Collection<VehicleRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, vehicleRecord, c ->
            c.map(id).toProperty("id")
            .map(brand).toProperty("brand")
            .map(type).toProperty("type")
            .map(buyYear).toProperty("buyYear")
            .map(license).toProperty("license")
            .map(company).toProperty("company")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int insertSelective(VehicleRecord record) {
        return MyBatis3Utils.insert(this::insert, record, vehicleRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(brand).toPropertyWhenPresent("brand", record::getBrand)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(buyYear).toPropertyWhenPresent("buyYear", record::getBuyYear)
            .map(license).toPropertyWhenPresent("license", record::getLicense)
            .map(company).toPropertyWhenPresent("company", record::getCompany)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default Optional<VehicleRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, vehicleRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default List<VehicleRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, vehicleRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default List<VehicleRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, vehicleRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default Optional<VehicleRecord> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, vehicleRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    static UpdateDSL<UpdateModel> updateAllColumns(VehicleRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(brand).equalTo(record::getBrand)
                .set(type).equalTo(record::getType)
                .set(buyYear).equalTo(record::getBuyYear)
                .set(license).equalTo(record::getLicense)
                .set(company).equalTo(record::getCompany);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(VehicleRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(brand).equalToWhenPresent(record::getBrand)
                .set(type).equalToWhenPresent(record::getType)
                .set(buyYear).equalToWhenPresent(record::getBuyYear)
                .set(license).equalToWhenPresent(record::getLicense)
                .set(company).equalToWhenPresent(record::getCompany);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int updateByPrimaryKey(VehicleRecord record) {
        return update(c ->
            c.set(brand).equalTo(record::getBrand)
            .set(type).equalTo(record::getType)
            .set(buyYear).equalTo(record::getBuyYear)
            .set(license).equalTo(record::getLicense)
            .set(company).equalTo(record::getCompany)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    default int updateByPrimaryKeySelective(VehicleRecord record) {
        return update(c ->
            c.set(brand).equalToWhenPresent(record::getBrand)
            .set(type).equalToWhenPresent(record::getType)
            .set(buyYear).equalToWhenPresent(record::getBuyYear)
            .set(license).equalToWhenPresent(record::getLicense)
            .set(company).equalToWhenPresent(record::getCompany)
            .where(id, isEqualTo(record::getId))
        );
    }
}