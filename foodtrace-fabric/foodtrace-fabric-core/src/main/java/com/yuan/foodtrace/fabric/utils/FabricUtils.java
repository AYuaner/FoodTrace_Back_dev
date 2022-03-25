package com.yuan.foodtrace.fabric.utils;

import org.apache.log4j.Logger;
import org.hyperledger.fabric.gateway.*;
import org.hyperledger.fabric.sdk.Channel;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;


public class FabricUtils {

    private static final Logger log = Logger.getLogger(FabricUtils.class);
    private static Network network;

    public static Contract getContract(String contractName) {
        try {
            network = getNetwork();
            return network.getContract(contractName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Channel getChannel() {
        return network.getChannel();
    }

    private static Network getNetwork() throws Exception {
        if (network == null) {
            synchronized (FabricUtils.class) {
                if (network == null) {
                    network = _getNetwork();
                }
            }
        }
        return network;
    }

    private static Network _getNetwork() throws Exception {

        String certificatePath = "foodtrace-fabric/foodtrace-fabric-core/src/main/resources/crypto-config/peerOrganizations/org1.example.com/users/User1@org1.example.com/msp/signcerts/cert.pem";
        String privateKeyPath = "foodtrace-fabric/foodtrace-fabric-core/src/main/resources/crypto-config/peerOrganizations/org1.example.com/users/User1@org1.example.com/msp/keystore/priv_sk";

        BufferedReader certificateReader = Files.newBufferedReader(Paths.get(certificatePath), StandardCharsets.UTF_8);
        X509Certificate certificate = Identities.readX509Certificate(certificateReader);
        BufferedReader privateKeyReader = Files.newBufferedReader(Paths.get(privateKeyPath), StandardCharsets.UTF_8);
        PrivateKey privateKey = Identities.readPrivateKey(privateKeyReader);

        // TODO 未来可能修改成多种身份
        Wallet wallet = Wallets.newInMemoryWallet();
        wallet.put("user1", Identities.newX509Identity("Org1MSP", certificate, privateKey));

        Gateway.Builder builder = Gateway.createBuilder()
                .identity(wallet, "user1")
                .networkConfig(Paths.get("foodtrace-fabric/foodtrace-fabric-core/src/main/resources/networkConnect.json"));
        Gateway gateway = builder.connect();
        log.info(gateway);

        return gateway.getNetwork("mychannel");
    }
}
