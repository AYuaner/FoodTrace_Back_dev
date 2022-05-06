package com.yuan.foodtrace.auth.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CompanyRecordDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: company")
    public static final CompanyRecord companyRecord = new CompanyRecord();

    /**
     * Database Column Remarks:
     *   唯一标识符
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: company.id")
    public static final SqlColumn<Long> id = companyRecord.id;

    /**
     * Database Column Remarks:
     *   公司名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: company.name")
    public static final SqlColumn<String> name = companyRecord.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: company")
    public static final class CompanyRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public CompanyRecord() {
            super("company");
        }
    }
}