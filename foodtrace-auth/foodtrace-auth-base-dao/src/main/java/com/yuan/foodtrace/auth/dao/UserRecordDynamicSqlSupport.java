package com.yuan.foodtrace.auth.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRecordDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final UserRecord userRecord = new UserRecord();

    /**
     * Database Column Remarks:
     *   唯一标识符
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.id")
    public static final SqlColumn<Long> id = userRecord.id;

    /**
     * Database Column Remarks:
     *   用户账号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.userName")
    public static final SqlColumn<String> username = userRecord.username;

    /**
     * Database Column Remarks:
     *   用户密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.password")
    public static final SqlColumn<String> password = userRecord.password;

    /**
     * Database Column Remarks:
     *   账号角色
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.role")
    public static final SqlColumn<String> role = userRecord.role;

    /**
     * Database Column Remarks:
     *   是否启用
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.enable")
    public static final SqlColumn<Boolean> enable = userRecord.enable;

    /**
     * Database Column Remarks:
     *   所属公司
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: user.company")
    public static final SqlColumn<String> company = userRecord.company;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final class UserRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("userName", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> role = column("role", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> enable = column("enable", JDBCType.BIT);

        public final SqlColumn<String> company = column("company", JDBCType.VARCHAR);

        public UserRecord() {
            super("user");
        }
    }
}