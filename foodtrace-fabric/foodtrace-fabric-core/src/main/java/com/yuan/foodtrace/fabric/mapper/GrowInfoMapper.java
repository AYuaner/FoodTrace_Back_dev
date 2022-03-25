package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.GrowInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;

import java.nio.charset.StandardCharsets;

public class GrowInfoMapper {

    private final Contract contract = FabricUtils.getContract("GrowInfo");

    public GrowInfo queryByPrimaryKey(String operaId) throws Exception {
        byte[] queryResult = contract.evaluateTransaction("QueryGrowInfoByOperId", operaId);
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        GrowInfo growInfo = JSON.parseObject(resultStr, GrowInfo.class);
        return growInfo == null ? new GrowInfo() : growInfo;
    }

    public boolean insert(GrowInfo info) throws Exception {
        byte[] insertResult = contract.createTransaction("InsertGrowInfo")
                .submit(info.getOperationId(),
                        info.getCropsId(),
                        info.getOperateType(),
                        info.getOperateTime(),
                        info.getOperatorId(),
                        info.getOperatorName(),
                        info.getTools(),
                        info.getRemarks());
        return insertResult.length != 0;
    }
}
