package com.yuan.foodtrace.auth.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class FarmRecordDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    public static final FarmRecord farmRecord = new FarmRecord();

    /**
     * Database Column Remarks:
     *   农场 ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: farm.id")
    public static final SqlColumn<String> id = farmRecord.id;

    /**
     * Database Column Remarks:
     *   农场名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: farm.name")
    public static final SqlColumn<String> name = farmRecord.name;

    /**
     * Database Column Remarks:
     *   所属公司
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: farm.company")
    public static final SqlColumn<String> company = farmRecord.company;

    /**
     * Database Column Remarks:
     *   具体地址
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: farm.location")
    public static final SqlColumn<String> location = farmRecord.location;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: farm")
    public static final class FarmRecord extends SqlTable {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> company = column("company", JDBCType.VARCHAR);

        public final SqlColumn<String> location = column("location", JDBCType.VARCHAR);

        public FarmRecord() {
            super("farm");
        }
    }
}