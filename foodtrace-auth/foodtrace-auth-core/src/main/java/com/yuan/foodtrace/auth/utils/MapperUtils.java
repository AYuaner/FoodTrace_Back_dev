package com.yuan.foodtrace.auth.utils;

import com.yuan.foodtrace.auth.domain.dto.UserDTO;
import com.yuan.foodtrace.auth.entity.UserRecord;

import java.util.Objects;

/**
 * 用于领域模型间转换
 *
 * @author A_Yuan
 */
public class MapperUtils {

    public static UserDTO UserEntityToDTO(UserRecord userRecord) {
        UserDTO userDTO = new UserDTO();
        if (!Objects.isNull(userRecord)) {
            userDTO.setId(userRecord.getId());
            userDTO.setUsername(userRecord.getUsername());
            userDTO.setPassword(userRecord.getPassword());
            userDTO.setRole(userRecord.getRole());
            userDTO.setEnable(userRecord.getEnable());
            userDTO.setCompany(userRecord.getCompany());
        }
        return userDTO;
    }
}
