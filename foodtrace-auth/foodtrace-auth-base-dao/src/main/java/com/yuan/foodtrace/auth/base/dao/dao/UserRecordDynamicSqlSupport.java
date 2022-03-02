package com.yuan.foodtrace.auth.base.dao.dao;

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
    public static final SqlColumn<String> id = userRecord.id;

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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: user")
    public static final class UserRecord extends SqlTable {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("userName", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> role = column("role", JDBCType.VARCHAR);

        public UserRecord() {
            super("user");
        }
    }
}