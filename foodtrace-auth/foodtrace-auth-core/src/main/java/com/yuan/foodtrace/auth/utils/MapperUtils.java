package com.yuan.foodtrace.auth.utils;

import com.yuan.foodtrace.auth.entity.UserRecord;
import com.yuan.foodtrace.auth.dto.UserDTO;

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
        }
        return userDTO;
    }

    public static UserRecord UserDTOToEntity(UserDTO userDTO) {
        UserRecord userRecord = new UserRecord();
        if (!Objects.isNull(userDTO)) {
            userRecord.setId(userDTO.getId());
            userRecord.setUsername(userDTO.getUsername());
            userRecord.setPassword(userDTO.getPassword());
            userRecord.setRole(userDTO.getRole());
            userRecord.setEnable(userDTO.getEnable());
        }
        return userRecord;
    }
}
