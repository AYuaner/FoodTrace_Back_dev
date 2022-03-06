package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.dto.UserDTO;
import com.yuan.foodtrace.auth.entity.UserRecord;
import com.yuan.foodtrace.auth.mapper.AccountMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号相关服务
 *
 * @author A_Yuan
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper mapper;

    public List<UserRecord> list() {
        return mapper.list();
    }

    public Boolean delete(UserDTO userDTO) {
        mapper.selectByPrimaryKey(userDTO.getId()).orElseThrow(() -> new RuntimeException("该id账号不存在"));
        UserRecord record = MapperUtils.UserDTOToEntity(userDTO);
        return mapper.updateEnableState(record) == 0 ? false : true;
    }

    public UserRecord findByUsername(String username) {
        return mapper.findByUsername(username).orElse(new UserRecord());
    }

    public Boolean insert(UserDTO userDTO) {
        UserRecord userByName = findByUsername(userDTO.getUsername());
        // 保证该用户名未被使用
        if (userByName.getId() == null) {
            UserRecord record = MapperUtils.UserDTOToEntity(userDTO);
            return mapper.insertSelective(record) == 0 ? false : true;
        }
        return false;
    }

    public Boolean update(UserDTO userDTO) {
        mapper.selectByPrimaryKey(userDTO.getId()).orElseThrow(() -> new RuntimeException("该id账号不存在"));
        UserRecord record = MapperUtils.UserDTOToEntity(userDTO);
        return mapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }
}
