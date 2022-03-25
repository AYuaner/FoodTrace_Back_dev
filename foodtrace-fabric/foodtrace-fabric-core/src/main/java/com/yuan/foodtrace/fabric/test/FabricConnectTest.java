package com.yuan.foodtrace.fabric.test;

import com.yuan.foodtrace.fabric.entity.Transportation;
import com.yuan.foodtrace.fabric.mapper.TransportationMapper;
import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.protos.common.Ledger;
import org.hyperledger.fabric.sdk.Channel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class FabricConnectTest {

    Contract contract;
    Channel channel;

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public void test() throws Exception {
        System.out.println("enter test()");
        contract = FabricUtils.getContract("Transportation");
        System.out.println(contract);

        System.out.println("=====================");
        byte[] resultOne = contract.evaluateTransaction("QueryTransportationByCropsId", "crops_id_test");
        System.out.println(new String(resultOne, StandardCharsets.UTF_8));

        System.out.println("=====================");
        byte[] resultTwo = contract.createTransaction("InsertTransportation")
                .submit("test_crops_id", "company", "startLoc", "startTime", "endLoc", "endTime", "vehicle", "driver", "remarks");
        System.out.println(new String(resultTwo, StandardCharsets.UTF_8));

        System.out.println("=====================");
        byte[] resultThree = contract.evaluateTransaction("QueryTransportationByCropsId", "test_crops_id");
        System.out.println(new String(resultThree, StandardCharsets.UTF_8));
    }

    @RequestMapping(value = "/block", method = RequestMethod.GET)
    public void testBlock() throws Exception {
        System.out.println("Enter testBlock()");
        channel = FabricUtils.getChannel();
        System.out.println(channel);

        Ledger.BlockchainInfo blockchainInfo = channel.queryBlockchainInfo().getBlockchainInfo();
        System.out.println(blockchainInfo.toString());
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public void testQuery() throws Exception {
        TransportationMapper mapper = new TransportationMapper();
        Transportation result = mapper.queryByPrimaryKey("crops_id_test");
        System.out.println(result);
    }
}
