package com.yuan.foodtrace.auth.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.yuan.foodtrace.auth.entity.UserRecord;
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
public interface UserBaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    BasicColumn[] selectList = BasicColumn.columnList(UserRecordDynamicSqlSupport.id, UserRecordDynamicSqlSupport.username, UserRecordDynamicSqlSupport.password, UserRecordDynamicSqlSupport.role);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserRecord> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<UserRecord> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserRecordResult")
    Optional<UserRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR)
    })
    List<UserRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, UserRecordDynamicSqlSupport.userRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, UserRecordDynamicSqlSupport.userRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(UserRecordDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int insert(UserRecord record) {
        return MyBatis3Utils.insert(this::insert, record, UserRecordDynamicSqlSupport.userRecord, c ->
            c.map(UserRecordDynamicSqlSupport.id).toProperty("id")
            .map(UserRecordDynamicSqlSupport.username).toProperty("username")
            .map(UserRecordDynamicSqlSupport.password).toProperty("password")
            .map(UserRecordDynamicSqlSupport.role).toProperty("role")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int insertMultiple(Collection<UserRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, UserRecordDynamicSqlSupport.userRecord, c ->
            c.map(UserRecordDynamicSqlSupport.id).toProperty("id")
            .map(UserRecordDynamicSqlSupport.username).toProperty("username")
            .map(UserRecordDynamicSqlSupport.password).toProperty("password")
            .map(UserRecordDynamicSqlSupport.role).toProperty("role")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int insertSelective(UserRecord record) {
        return MyBatis3Utils.insert(this::insert, record, UserRecordDynamicSqlSupport.userRecord, c ->
            c.map(UserRecordDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(UserRecordDynamicSqlSupport.username).toPropertyWhenPresent("username", record::getUsername)
            .map(UserRecordDynamicSqlSupport.password).toPropertyWhenPresent("password", record::getPassword)
            .map(UserRecordDynamicSqlSupport.role).toPropertyWhenPresent("role", record::getRole)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default Optional<UserRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, UserRecordDynamicSqlSupport.userRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default List<UserRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, UserRecordDynamicSqlSupport.userRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default List<UserRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, UserRecordDynamicSqlSupport.userRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default Optional<UserRecord> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(UserRecordDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, UserRecordDynamicSqlSupport.userRecord, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateAllColumns(UserRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserRecordDynamicSqlSupport.id).equalTo(record::getId)
                .set(UserRecordDynamicSqlSupport.username).equalTo(record::getUsername)
                .set(UserRecordDynamicSqlSupport.password).equalTo(record::getPassword)
                .set(UserRecordDynamicSqlSupport.role).equalTo(record::getRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserRecord record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(UserRecordDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(UserRecordDynamicSqlSupport.username).equalToWhenPresent(record::getUsername)
                .set(UserRecordDynamicSqlSupport.password).equalToWhenPresent(record::getPassword)
                .set(UserRecordDynamicSqlSupport.role).equalToWhenPresent(record::getRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int updateByPrimaryKey(UserRecord record) {
        return update(c ->
            c.set(UserRecordDynamicSqlSupport.username).equalTo(record::getUsername)
            .set(UserRecordDynamicSqlSupport.password).equalTo(record::getPassword)
            .set(UserRecordDynamicSqlSupport.role).equalTo(record::getRole)
            .where(UserRecordDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    default int updateByPrimaryKeySelective(UserRecord record) {
        return update(c ->
            c.set(UserRecordDynamicSqlSupport.username).equalToWhenPresent(record::getUsername)
            .set(UserRecordDynamicSqlSupport.password).equalToWhenPresent(record::getPassword)
            .set(UserRecordDynamicSqlSupport.role).equalToWhenPresent(record::getRole)
            .where(UserRecordDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}