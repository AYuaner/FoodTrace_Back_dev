package com.yuan.foodtrace.auth.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class WorkerRecordDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    public static final WorkerRecord workerRecord = new WorkerRecord();

    /**
     * Database Column Remarks:
     *   工人 ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id")
    public static final SqlColumn<String> id = workerRecord.id;

    /**
     * Database Column Remarks:
     *   姓名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.name")
    public static final SqlColumn<String> name = workerRecord.name;

    /**
     * Database Column Remarks:
     *   身份证号码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id_number")
    public static final SqlColumn<String> idNumber = workerRecord.idNumber;

    /**
     * Database Column Remarks:
     *   手机号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.phone_number")
    public static final SqlColumn<String> phoneNumber = workerRecord.phoneNumber;

    /**
     * Database Column Remarks:
     *   年龄
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.age")
    public static final SqlColumn<Integer> age = workerRecord.age;

    /**
     * Database Column Remarks:
     *   性别
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.gender")
    public static final SqlColumn<Boolean> gender = workerRecord.gender;

    /**
     * Database Column Remarks:
     *   所属公司
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.company")
    public static final SqlColumn<String> company = workerRecord.company;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    public static final class WorkerRecord extends SqlTable {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> idNumber = column("id_number", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNumber = column("phone_number", JDBCType.VARCHAR);

        public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

        public final SqlColumn<Boolean> gender = column("gender", JDBCType.BIT);

        public final SqlColumn<String> company = column("company", JDBCType.VARCHAR);

        public WorkerRecord() {
            super("worker");
        }
    }
}