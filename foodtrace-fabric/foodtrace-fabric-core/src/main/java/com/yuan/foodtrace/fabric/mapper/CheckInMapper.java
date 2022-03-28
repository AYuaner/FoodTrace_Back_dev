package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.CheckIn;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class CheckInMapper {

    private final Contract contract = FabricUtils.getContract("CheckIn");

    public CheckIn queryByPrimaryKey(String cropsId) {
        byte[] queryResult = new byte[0];
        try {
            queryResult = contract.evaluateTransaction("QueryCheckInByCropsId", cropsId);
        } catch (ContractException e) {
            e.printStackTrace();
            return new CheckIn();
        }
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        CheckIn checkIn = JSON.parseObject(resultStr, CheckIn.class);
        return checkIn == null ? new CheckIn() : checkIn;
    }

    public boolean insert(CheckIn info) {
        byte[] insertResult = new byte[0];
        try {
            insertResult = contract.createTransaction("InsertCheckIn")
                    .submit(info.getCropsId(),
                            info.getCompany(),
                            info.getLocation(),
                            info.getOperatorId(),
                            info.getOperatorName(),
                            info.getRemarks());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return insertResult.length == 0;
    }

    public List<CheckIn> queryAll() {
        byte[] result = new byte[0];
        try {
            result = contract.evaluateTransaction("QueryAll");

        } catch (ContractException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        String resultStr = new String(result, StandardCharsets.UTF_8);
        List<CheckIn> checkIns = JSON.parseArray(resultStr, CheckIn.class);
        return checkIns == null ? new ArrayList<>() : checkIns;
    }
}
