package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeedInfoMapper {

    private final Contract contract = FabricUtils.getContract("SeedInfo");

    public SeedInfo queryByPrimaryKey(String cropsId) {
        byte[] queryResult = new byte[0];
        try {
            queryResult = contract.evaluateTransaction("QuerySeedInfoByCropsId", cropsId);
        } catch (ContractException e) {
            e.printStackTrace();
            return new SeedInfo();
        }
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        SeedInfo seedInfo = JSON.parseObject(resultStr, SeedInfo.class);
        return seedInfo == null ? new SeedInfo() : seedInfo;
    }

    public boolean insert(SeedInfo info) {
        byte[] insertResult = new byte[0];
        try {
            insertResult = contract.createTransaction("InsertSeedInfo")
                    .submit(info.getCropsId(),
                            info.getCropsName(),
                            info.getAddress(),
                            info.getSeedTime(),
                            info.getCreatedTime(),
                            info.getFarmId(),
                            info.getFarmName(),
                            info.getOperatorId(),
                            info.getOperatorId(),
                            info.getOperatorName(),
                            info.getRemarks()
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return insertResult.length == 0;
    }

    public List<SeedInfo> queryAll() {
        byte[] result = new byte[0];
        try {
            result = contract.evaluateTransaction("QueryAll");

        } catch (ContractException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        String resultStr = new String(result, StandardCharsets.UTF_8);
        List<SeedInfo> seedInfos = JSON.parseArray(resultStr, SeedInfo.class);
        return seedInfos == null ? new ArrayList<>() : seedInfos;
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
