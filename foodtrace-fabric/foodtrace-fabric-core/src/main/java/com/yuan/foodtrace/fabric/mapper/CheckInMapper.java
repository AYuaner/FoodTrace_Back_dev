package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.CheckIn;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;

import java.nio.charset.StandardCharsets;

public class CheckInMapper {

    private final Contract contract = FabricUtils.getContract("CheckIn");

    public CheckIn queryByPrimaryKey(String cropsId) throws Exception {
        byte[] queryResult = contract.evaluateTransaction("QueryCheckInByCropsId", cropsId);
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        CheckIn checkIn = JSON.parseObject(resultStr, CheckIn.class);
        return checkIn == null ? new CheckIn() : checkIn;
    }

    public boolean insert(CheckIn info) throws Exception {
        byte[] insertResult = contract.createTransaction("InsertCheckIn")
                .submit(info.getCropsId(),
                        info.getCompany(),
                        info.getLocation(),
                        info.getOperatorId(),
                        info.getOperatorName(),
                        info.getRemarks());
        return insertResult.length != 0;
    }
}
