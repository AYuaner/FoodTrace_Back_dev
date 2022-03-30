package com.yuan.foodtrace.auth.dao;

import static com.yuan.foodtrace.auth.dao.FarmRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.yuan.foodtrace.auth.entity.FarmRecord;
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
public interface FarmBaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, company, location);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<FarmRecord> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<FarmRecord> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FarmRecordResult")
    Optional<FarmRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FarmRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR)
    })
    List<FarmRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, farmRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, farmRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int insert(FarmRecord record) {
        return MyBatis3Utils.insert(this::insert, record, farmRecord, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(company).toProperty("company")
            .map(location).toProperty("location")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int insertMultiple(Collection<FarmRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, farmRecord, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(company).toProperty("company")
            .map(location).toProperty("location")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int insertSelective(FarmRecord record) {
        return MyBatis3Utils.insert(this::insert, record, farmRecord, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(company).toPropertyWhenPresent("company", record::getCompany)
            .map(location).toPropertyWhenPresent("location", record::getLocation)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default Optional<FarmRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, farmRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default List<FarmRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, farmRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default List<FarmRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, farmRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default Optional<FarmRecord> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, farmRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    static UpdateDSL<UpdateModel> updateAllColumns(FarmRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(company).equalTo(record::getCompany)
                .set(location).equalTo(record::getLocation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(FarmRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(company).equalToWhenPresent(record::getCompany)
                .set(location).equalToWhenPresent(record::getLocation);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int updateByPrimaryKey(FarmRecord record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(company).equalTo(record::getCompany)
            .set(location).equalTo(record::getLocation)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    default int updateByPrimaryKeySelective(FarmRecord record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(company).equalToWhenPresent(record::getCompany)
            .set(location).equalToWhenPresent(record::getLocation)
            .where(id, isEqualTo(record::getId))
        );
    }
}