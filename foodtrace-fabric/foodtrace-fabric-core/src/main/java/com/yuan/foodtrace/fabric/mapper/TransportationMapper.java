package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.entity.Transportation;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransportationMapper {

    private final Contract contract = FabricUtils.getContract("Transportation");

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
                            info.getCreatedTime(),
                            info.getRemarks());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // 若Result有返回值，则表示智能合约返回错误，插入失败，返回false
        return insertResult.length == 0;
    }

    public List<Transportation> queryAll() {
        byte[] result = new byte[0];
        try {
            result = contract.evaluateTransaction("QueryAll");

        } catch (ContractException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        String resultStr = new String(result, StandardCharsets.UTF_8);
        List<Transportation> transportations = JSON.parseArray(resultStr, Transportation.class);
        return transportations == null ? new ArrayList<>() : transportations;
    }

    public int count() {
        byte[] result;
        try {
            result = contract.evaluateTransaction("GetCount");
        } catch (ContractException e) {
            e.printStackTrace();
            return -1;
        }
        String count = new String(result, StandardCharsets.UTF_8);
        return Integer.parseInt(count);
    }
}
