package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.dto.UserDTO;
import com.yuan.foodtrace.auth.entity.UserRecord;
import com.yuan.foodtrace.auth.mapper.UserMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author A_Yuan
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserDTO findByUsername(String userName) {
        UserRecord userRecord = userMapper.findByUsername(userName).orElse(new UserRecord());
        return MapperUtils.UserEntityToDTO(userRecord);
    }

    public UserDTO findUserById(Long id) {
        UserRecord userRecord = userMapper.findUserById(id).orElse(new UserRecord());
        return MapperUtils.UserEntityToDTO(userRecord);
    }
}
