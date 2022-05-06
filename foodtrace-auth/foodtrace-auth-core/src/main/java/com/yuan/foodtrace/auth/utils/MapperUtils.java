package com.yuan.foodtrace.auth.utils;

import com.yuan.foodtrace.auth.domain.dto.FarmDTO;
import com.yuan.foodtrace.auth.domain.dto.VehicleDTO;
import com.yuan.foodtrace.auth.domain.dto.WorkerDTO;
import com.yuan.foodtrace.auth.domain.dto.UserDTO;

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

    public static UserRecord UserDTOToEntity(UserDTO userDTO) {
        UserRecord userRecord = new UserRecord();
        if (!Objects.isNull(userDTO)) {
            userRecord.setId(userDTO.getId());
            userRecord.setUsername(userDTO.getUsername());
            userRecord.setPassword(userDTO.getPassword());
            userRecord.setRole(userDTO.getRole());
            userRecord.setEnable(userDTO.getEnable());
            userRecord.setCompany(userDTO.getCompany());
        }
        return userRecord;
    }

    public static FarmDTO FarmEntityToDTO(FarmRecord entity) {
        FarmDTO dto = new FarmDTO();
        if (!Objects.isNull(entity)) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCompany(entity.getCompany());
            dto.setLocation(entity.getLocation());
        }
        return dto;
    }

    public static FarmRecord FarmDTOToEntity(FarmDTO dto) {
        FarmRecord entity = new FarmRecord();
        if (!Objects.isNull(dto)) {
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setCompany(dto.getCompany());
            entity.setLocation(dto.getLocation());
        }
        return entity;
    }

    public static WorkerDTO WorkerEntityToDTO(WorkerRecord entity) {
        WorkerDTO dto = new WorkerDTO();
        if (!Objects.isNull(entity)) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setIdNumber(entity.getIdNumber());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCompany(entity.getCompany());
        }
        return dto;
    }

    public static WorkerRecord WorkerDTOToEntity(WorkerDTO dto) {
        WorkerRecord entity = new WorkerRecord();
        if (!Objects.isNull(entity)) {
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setIdNumber(dto.getIdNumber());
            entity.setPhoneNumber(dto.getPhoneNumber());
            entity.setAge(dto.getAge());
            entity.setGender(dto.getGender());
            entity.setCompany(dto.getCompany());
        }
        return entity;
    }

    public static VehicleDTO VehicleEntityToDTO(VehicleDTO entity) {
        VehicleDTO dto = new VehicleDTO();
        if (!Objects.isNull(entity)) {
            dto.setId(entity.getId());
            dto.setBrand(entity.getBrand());
            dto.setType(entity.getType());
            dto.setBuyYear(entity.getBuyYear());
            dto.setLicense(entity.getLicense());
            dto.setCompany(dto.getCompany());
        }
        return dto;
    }

    public static VehicleRecord VehicleDTOToEntity(VehicleDTO dto) {
        VehicleRecord entity = new VehicleRecord();
        if (!Objects.isNull(entity)) {
            entity.setId(dto.getId());
            entity.setBrand(dto.getBrand());
            entity.setType(dto.getType());
            entity.setBuyYear(dto.getBuyYear());
            entity.setLicense(dto.getLicense());
            entity.setCompany(dto.getCompany());
        }
        return entity;
    }
}
