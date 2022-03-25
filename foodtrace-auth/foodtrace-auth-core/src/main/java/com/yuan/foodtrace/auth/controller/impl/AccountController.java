package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.controller.api.AccountApi;
import com.yuan.foodtrace.auth.dto.UserDTO;
import com.yuan.foodtrace.auth.entity.UserRecord;
import com.yuan.foodtrace.auth.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author A_Yuan
 */
@RestController
public class AccountController implements AccountApi {

    @Autowired
    AccountService accountService;

    @Override
    public Object listAccount() {
        JSONObject jsonObject = new JSONObject();
        List<UserRecord> list = accountService.list();
        jsonObject.put("accounts", list);
        return jsonObject;
    }

    @Override
    public Object deleteAccount(UserDTO userDTO) {
        System.out.println(userDTO);
        JSONObject jsonObject = new JSONObject();
        UserDTO DTO = new UserDTO();
        userDTO.setId(userDTO.getId());
        userDTO.setEnable(userDTO.getEnable());
        Boolean result = accountService.delete(userDTO);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object newAccount(UserDTO userDTO) {
        JSONObject jsonObject = new JSONObject();
        UserDTO dto = new UserDTO();
        dto.setUsername(userDTO.getUsername().replaceAll("\\W", ""));
        dto.setPassword(userDTO.getPassword().replaceAll("\\W", ""));
        dto.setRole(userDTO.getRole().replaceAll("\\W", ""));

        if (StringUtils.isEmpty(dto.getUsername())) {
            jsonObject.put("result", false);
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getPassword())) {
            jsonObject.put("result", false);
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getRole())) {
            jsonObject.put("result", false);
            return jsonObject;
        }

        Boolean result = accountService.insert(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object updateAccount(UserDTO userDTO) {
        JSONObject jsonObject = new JSONObject();
        assert userDTO.getId() != null;
        Boolean result = accountService.update(userDTO);
        jsonObject.put("result", result);
        return jsonObject;
    }
}
