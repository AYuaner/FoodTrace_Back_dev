package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.PickInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;

import java.nio.charset.StandardCharsets;

public class PickInfoMapper {

    private final Contract contract = FabricUtils.getContract("PickInfo");

    public PickInfo queryByPrimaryKey(String cropsId) throws Exception {
        byte[] queryResult = contract.evaluateTransaction("QueryPickInfoByCropsId", cropsId);
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        PickInfo pickInfo = JSON.parseObject(resultStr, PickInfo.class);
        return pickInfo == null ? new PickInfo() : pickInfo;
    }

    public boolean insert(PickInfo info) throws Exception {
        byte[] insertResult = contract.createTransaction("InsertPickInfo")
                .submit(info.getCropsId(),
                        info.getOperateTime(),
                        info.getOperatorId(),
                        info.getOperatorName(),
                        info.getRemarks());
        return insertResult.length != 0;
    }
}
