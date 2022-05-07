package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.VehicleDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.VehicleInsertCommand;
import com.yuan.foodtrace.auth.domain.command.VehicleUpdateCommand;
import com.yuan.foodtrace.auth.entity.VehicleRecord;
import com.yuan.foodtrace.auth.mapper.VehicleMapper;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleMapper vehicleMapper;

    /**
     * get the list of vehicle owned by operator's company.
     *
     * @param operatorCompany the company work at or onw
     * @return list of VehicleRecord
     */
    public List<VehicleRecord> listWithCompany(String operatorCompany) {
        return vehicleMapper.listWithCompany(operatorCompany);
    }

    /**
     * get list of all vehicle
     *
     * @return list of VehicleRecord
     */
    public List<VehicleRecord> list() {
        return vehicleMapper.list();
    }

    /**
     * insert a new vehicle record.
     *
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
        if (TokenUtils.checkRoleEqualToAdmin(command.getOperatorCompany())) {
            record.setCompany(command.getCompany());
        }
        record.setCompany(command.getOperatorCompany());
        record.setLicense(command.getLicense());
        return vehicleMapper.insert(record) == 0 ? false : true;
    }

    /**
     * delete a vehicle record.
     *
     * @param command the arguments DELETE need
     * @return result of operation
     */
    public boolean delete(VehicleDeleteCommand command) {
        if (!_validateIdAndCompany(command.getId(), command.getOperatorCompany())) {
            return false;
        }
        if (!_validateIdAndLicense(command.getId(), command.getLicense())) {
            return false;
        }
        return vehicleMapper.deleteByPrimaryKey(command.getId()) == 0 ? false : true;
    }

    /**
     * update a vehicle record.
     *
     * @param command a record with new value of field
     * @return result fo operation
     */
    public boolean update(VehicleUpdateCommand command) {
        if (!_validateIdAndCompany(command.getId(), command.getOperatorCompany())) {
            return false;
        }
        VehicleRecord record = new VehicleRecord();
        record.setId(command.getId());
        record.setBrand(command.getBrand());
        record.setType(command.getType());
        record.setBuyYear(command.getBuyYear());
        record.setLicense(command.getLicense());
        if (TokenUtils.checkRoleEqualToAdmin(command.getOperatorCompany())) {
            record.setCompany(command.getCompany());
        }
        record.setCompany(command.getOperatorCompany());
        return vehicleMapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    /**
     * to ensure `license` not be used.
     */
    private boolean _validateLicenseNoUse(String license) {
        VehicleRecord record = vehicleMapper.findByLicense(license).orElse(new VehicleRecord());
        return record.getId() == null;
    }

    /**
     * to ensure operator can only operate the record his company own
     */
    private boolean _validateIdAndCompany(Long id, String operatorCompany) {
        VehicleRecord record = vehicleMapper.selectByPrimaryKey(id).orElse(new VehicleRecord());
        return StringUtils.equals(record.getCompany(), operatorCompany)
                || "admin".equalsIgnoreCase(operatorCompany);
    }

    /**
     * to ensure `id` and `license` can match.
     */
    private boolean _validateIdAndLicense(Long id, String license) {
        VehicleRecord record = vehicleMapper.selectByPrimaryKey(id).orElse(new VehicleRecord());
        return StringUtils.equals(record.getLicense(), license);
    }
}
