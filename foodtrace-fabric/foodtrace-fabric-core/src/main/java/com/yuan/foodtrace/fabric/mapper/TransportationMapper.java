package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.Transportation;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;

import java.nio.charset.StandardCharsets;

public class TransportationMapper {

    private final Contract contract = FabricUtils.getContract("SeedInfo");

    public Transportation queryByPrimaryKey(String cropsId) {
        byte[] queryResult = new byte[0];
        try {
            queryResult = contract.evaluateTransaction("QueryTransportationByCropsId", cropsId);
        } catch (ContractException e) {
            e.printStackTrace();
            return new Transportation();
        }
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        Transportation transportation = JSON.parseObject(resultStr, Transportation.class);
        return transportation == null ? new Transportation() : transportation;
    }

    public boolean insert(Transportation info) {
        byte[] insertResult = new byte[0];
        try {
            insertResult = contract.createTransaction("InsertTransportation")
                    .submit(info.getCropsId(),
                            info.getCompany(),
                            info.getStartLocation(),
                            info.getStartTime(),
                            info.getEndLocation(),
                            info.getEndTime(),
                            info.getVehicle(),
                            info.getDriver(),
                            info.getRemarks());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // 若Result有返回值，则表示智能合约返回错误，插入失败，返回false
        return insertResult.length != 0;
    }
}
