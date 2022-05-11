package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.GrowInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class GrowInfoMapper {

    private final Contract contract = FabricUtils.getContract("GrowInfo");

    public GrowInfo queryByPrimaryKey(String operaId) {
        byte[] queryResult = new byte[0];
        try {
            queryResult = contract.evaluateTransaction("QueryGrowInfoByOperId", operaId);
        } catch (ContractException e) {
            e.printStackTrace();
            return new GrowInfo();
        }
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        GrowInfo growInfo = JSON.parseObject(resultStr, GrowInfo.class);
        return growInfo == null ? new GrowInfo() : growInfo;
    }

    public boolean insert(GrowInfo info) {
        System.out.println(info);
        byte[] insertResult = new byte[0];
        try {
            insertResult = contract.createTransaction("InsertGrowInfo")
                    .submit(info.getOperationId(),
                            info.getCropsId(),
                            info.getOperateType(),
                            info.getOperateTime(),
                            info.getOperatorId(),
                            info.getOperatorName(),
                            info.getTools(),
                            info.getCreatedTime(),
                            info.getRemarks());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return insertResult.length == 0;
    }

    public List<GrowInfo> queryAll() {
        byte[] result = new byte[0];
        try {
            result = contract.evaluateTransaction("QueryAll");

        } catch (ContractException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        String resultStr = new String(result, StandardCharsets.UTF_8);
        List<GrowInfo> growInfos = JSON.parseArray(resultStr, GrowInfo.class);
        return growInfos == null ? new ArrayList<>() : growInfos;
    }

    public List<GrowInfo> queryByCropsId(String cropsId) {
        byte[] result = new byte[0];
        try {
            result = contract.evaluateTransaction("QueryGrowInfoByCropsId", cropsId);
        } catch (ContractException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        String resultStr = new String(result, StandardCharsets.UTF_8);
        List<GrowInfo> growInfos = JSON.parseArray(resultStr, GrowInfo.class);
        return growInfos == null ? new ArrayList<>() : growInfos;
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
