package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;

import java.nio.charset.StandardCharsets;

public class SeedInfoMapper {

    private final Contract contract = FabricUtils.getContract("SeedInfo");

    public SeedInfo queryByPrimaryKey(String cropsId) throws Exception {
        byte[] queryResult = contract.evaluateTransaction("QuerySeedInfoByCropsId", cropsId);
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        SeedInfo seedInfo = JSON.parseObject(resultStr, SeedInfo.class);
        return seedInfo == null ? new SeedInfo() : seedInfo;
    }

    public boolean insert(SeedInfo info) throws Exception {
        byte[] insertResult = contract.createTransaction("InsertSeedInfo")
                .submit(info.getCropsId(),
                        info.getCropsName(),
                        info.getAddress(),
                        info.getSeedTime(),
                        info.getFarmId(),
                        info.getFarmName(),
                        info.getOperatorId(),
                        info.getOperatorId(),
                        info.getOperatorName(),
                        info.getRemarks()
                );
        return insertResult.length != 0;
    }
}
