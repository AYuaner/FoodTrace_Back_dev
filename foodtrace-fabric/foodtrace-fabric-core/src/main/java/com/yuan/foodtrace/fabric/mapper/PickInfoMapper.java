package com.yuan.foodtrace.fabric.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.PickInfo;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class PickInfoMapper {

    private final Contract contract = FabricUtils.getContract("PickInfo");

    public PickInfo queryByPrimaryKey(String cropsId) {
        byte[] queryResult = new byte[0];
        try {
            queryResult = contract.evaluateTransaction("QueryPickInfoByCropsId", cropsId);
        } catch (ContractException e) {
            e.printStackTrace();
            return new PickInfo();
        }
        String resultStr = new String(queryResult, StandardCharsets.UTF_8);
        PickInfo pickInfo = JSON.parseObject(resultStr, PickInfo.class);
        return pickInfo == null ? new PickInfo() : pickInfo;
    }

    public boolean insert(PickInfo info) {
        byte[] insertResult = new byte[0];
        try {
            insertResult = contract.createTransaction("InsertPickInfo")
                    .submit(info.getCropsId(),
                            info.getOperateTime(),
                            info.getOperatorId(),
                            info.getOperatorName(),
                            info.getCreatedTime(),
                            info.getRemarks());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return insertResult.length == 0;
    }

    public List<PickInfo> queryAll() {
        byte[] result = new byte[0];
        try {
            result = contract.evaluateTransaction("QueryAll");

        } catch (ContractException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        String resultStr = new String(result, StandardCharsets.UTF_8);
        List<PickInfo> pickInfos = JSON.parseArray(resultStr, PickInfo.class);
        return pickInfos == null ? new ArrayList<>() : pickInfos;
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
