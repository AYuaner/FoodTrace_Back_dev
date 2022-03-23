package com.yuan.foodtrace.fabric.test;

import com.yuan.foodtrace.fabric.utils.FabricUtils;
import org.hyperledger.fabric.gateway.Contract;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class FabricConnectTest {

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public void test() throws Exception {
        System.out.println("enter test()");
        Contract contract = FabricUtils.getContract("Transportation");
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
}
