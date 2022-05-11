package com.yuan.foodtrace.auth.dao;

import static com.yuan.foodtrace.auth.dao.WorkerRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.yuan.foodtrace.auth.entity.WorkerRecord;
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
public interface WorkerBaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, idNumber, phoneNumber, age, gender, company);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<WorkerRecord> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<WorkerRecord> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("WorkerRecordResult")
    Optional<WorkerRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="WorkerRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_number", property="idNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="gender", property="gender", jdbcType=JdbcType.BIT),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR)
    })
    List<WorkerRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, workerRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, workerRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int insert(WorkerRecord record) {
        return MyBatis3Utils.insert(this::insert, record, workerRecord, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(idNumber).toProperty("idNumber")
            .map(phoneNumber).toProperty("phoneNumber")
            .map(age).toProperty("age")
            .map(gender).toProperty("gender")
            .map(company).toProperty("company")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int insertMultiple(Collection<WorkerRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, workerRecord, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(idNumber).toProperty("idNumber")
            .map(phoneNumber).toProperty("phoneNumber")
            .map(age).toProperty("age")
            .map(gender).toProperty("gender")
            .map(company).toProperty("company")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int insertSelective(WorkerRecord record) {
        return MyBatis3Utils.insert(this::insert, record, workerRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(idNumber).toPropertyWhenPresent("idNumber", record::getIdNumber)
            .map(phoneNumber).toPropertyWhenPresent("phoneNumber", record::getPhoneNumber)
            .map(age).toPropertyWhenPresent("age", record::getAge)
            .map(gender).toPropertyWhenPresent("gender", record::getGender)
            .map(company).toPropertyWhenPresent("company", record::getCompany)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default Optional<WorkerRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, workerRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default List<WorkerRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, workerRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default List<WorkerRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, workerRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default Optional<WorkerRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, workerRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    static UpdateDSL<UpdateModel> updateAllColumns(WorkerRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(idNumber).equalTo(record::getIdNumber)
                .set(phoneNumber).equalTo(record::getPhoneNumber)
                .set(age).equalTo(record::getAge)
                .set(gender).equalTo(record::getGender)
                .set(company).equalTo(record::getCompany);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(WorkerRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(idNumber).equalToWhenPresent(record::getIdNumber)
                .set(phoneNumber).equalToWhenPresent(record::getPhoneNumber)
                .set(age).equalToWhenPresent(record::getAge)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(company).equalToWhenPresent(record::getCompany);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int updateByPrimaryKey(WorkerRecord record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(idNumber).equalTo(record::getIdNumber)
            .set(phoneNumber).equalTo(record::getPhoneNumber)
            .set(age).equalTo(record::getAge)
            .set(gender).equalTo(record::getGender)
            .set(company).equalTo(record::getCompany)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    default int updateByPrimaryKeySelective(WorkerRecord record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(idNumber).equalToWhenPresent(record::getIdNumber)
            .set(phoneNumber).equalToWhenPresent(record::getPhoneNumber)
            .set(age).equalToWhenPresent(record::getAge)
            .set(gender).equalToWhenPresent(record::getGender)
            .set(company).equalToWhenPresent(record::getCompany)
            .where(id, isEqualTo(record::getId))
        );
    }
}