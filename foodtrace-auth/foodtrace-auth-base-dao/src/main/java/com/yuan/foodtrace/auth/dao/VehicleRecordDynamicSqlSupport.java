package com.yuan.foodtrace.auth.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VehicleRecordDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    public static final VehicleRecord vehicleRecord = new VehicleRecord();

    /**
     * Database Column Remarks:
     *   车辆标识码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.id")
    public static final SqlColumn<String> id = vehicleRecord.id;

    /**
     * Database Column Remarks:
     *   品牌
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.brand")
    public static final SqlColumn<String> brand = vehicleRecord.brand;

    /**
     * Database Column Remarks:
     *   车辆型号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.type")
    public static final SqlColumn<String> type = vehicleRecord.type;

    /**
     * Database Column Remarks:
     *   购买年份
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.buy_year")
    public static final SqlColumn<String> buyYear = vehicleRecord.buyYear;

    /**
     * Database Column Remarks:
     *   车牌
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.license")
    public static final SqlColumn<String> license = vehicleRecord.license;

    /**
     * Database Column Remarks:
     *   所属公司
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.company")
    public static final SqlColumn<String> company = vehicleRecord.company;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    public static final class VehicleRecord extends SqlTable {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> brand = column("brand", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<String> buyYear = column("buy_year", JDBCType.VARCHAR);

        public final SqlColumn<String> license = column("license", JDBCType.VARCHAR);

        public final SqlColumn<String> company = column("company", JDBCType.VARCHAR);

        public VehicleRecord() {
            super("vehicle");
        }
    }
}