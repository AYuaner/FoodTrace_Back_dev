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
    public Object deleteAccount(Long id) {
        JSONObject jsonObject = new JSONObject();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setEnable(false);
        Boolean result = accountService.delete(userDTO);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object getAccount(String username) {
        JSONObject jsonObject = new JSONObject();
        UserRecord result = accountService.findByUsername(username);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object newAccount(UserDTO userDTO) {
        JSONObject jsonObject = new JSONObject();
        assert StringUtils.isNotEmpty(userDTO.getUsername());
        assert StringUtils.isNotEmpty(userDTO.getPassword());
        assert userDTO.getId() == null;
        assert StringUtils.isNotEmpty(userDTO.getRole());
        Boolean result = accountService.insert(userDTO);
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
