package com.yuan.foodtrace.auth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yuan.foodtrace.auth.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author A_Yuan
 */
@Service
public class TokenService {

    public String getToken(UserDTO userDTO) {
        Date start = new Date();
        // 有效时间：一小时
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;
        Date end = new Date(currentTime);

        System.out.println("company" + userDTO.getCompany());

        return JWT.create()
                .withAudience(userDTO.getUsername())
                .withClaim("company", userDTO.getCompany())
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(userDTO.getPassword()));
    }
}
