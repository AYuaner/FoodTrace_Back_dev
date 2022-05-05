package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.VehicleDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.VehicleInsertCommand;
import com.yuan.foodtrace.auth.domain.command.VehicleUpdateCommand;
import com.yuan.foodtrace.auth.domain.dto.VehicleDTO;
import com.yuan.foodtrace.auth.entity.VehicleRecord;
import com.yuan.foodtrace.auth.mapper.VehicleMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yuan.foodtrace.auth.dao.VehicleRecordDynamicSqlSupport.license;

@Service
public class VehicleService {

    @Autowired
    VehicleMapper vehicleMapper;

    /**
     * get the list of vehicle owned by operator's company.
     * @param company the company work at or onw
     * @return list of VehicleRecord
     */
    public List<VehicleRecord> list(String company) {
        return vehicleMapper.list(company);
    }

    /**
     * insert a new vehicle record.
     * @param command the arguments INSERT need
     * @return result of operation
     */
    public boolean insert(VehicleInsertCommand command) {
        if (!_validateLicenseNoUse(command.getLicense())) {
            return false;
        }
        VehicleRecord record = new VehicleRecord();
        record.setType(command.getType());
        record.setBrand(command.getBrand());
        record.setBuyYear(command.getBuyYear());
        record.setCompany(command.getCompany());
        record.setLicense(command.getLicense());
        return vehicleMapper.insert(record) == 0 ? false : true;
    }

    /**
     * delete a vehicle record.
     * @param command the arguments DELETE need
     * @return result of operation
     */
    public boolean delete(VehicleDeleteCommand command) {
        if (!_validateIdCompanyLicense(command.getId(), command.getOperatorCompany(), command.getLicense())) {
            return false;
        }
        return vehicleMapper.deleteByPrimaryKey(command.getId()) == 0 ? false : true;
    }

    /**
     * update a vehicle record.
     * @param command a record with new value of field
     * @return result fo operation
     */
    public boolean update(VehicleUpdateCommand command) {
        if (!_validateIdCompanyLicense(command.getId(), command.getOperatorCompany(), command.getLicense())) {
            return false;
        }
        VehicleRecord record = new VehicleRecord();
        record.setId(command.getId());
        record.setBrand(command.getBrand());
        record.setType(command.getType());
        record.setBuyYear(command.getBuyYear());
        record.setLicense(command.getLicense());
        record.setCompany(command.getCompany());
        return vehicleMapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    /**
     * to ensure `license` not be used.
     */
    private boolean _validateLicenseNoUse(String license) {
        VehicleRecord record = vehicleMapper.findByLicense(license)
                .orElseThrow(() -> new RuntimeException("该license的vehicle不存在"));
        return record.getId() != null;
    }

    /**
     * to ensure
     * operator can only operate the record his company own
     * `id` and `license` can match.
     */
    private boolean _validateIdCompanyLicense(String id, String operatorCompany, String license) {
        VehicleRecord record = vehicleMapper.selectByPrimaryKey(id)
                .orElseThrow(() -> new RuntimeException("该id vehicle不存在"));
        if (!StringUtils.equals(record.getCompany(), operatorCompany)) {
            return false;
        }
        if (!"admin".equalsIgnoreCase(record.getCompany())) {
            return false;
        }
        if (!StringUtils.equals(record.getLicense(), license)) {
            return false;
        }
        return true;
    }
}
