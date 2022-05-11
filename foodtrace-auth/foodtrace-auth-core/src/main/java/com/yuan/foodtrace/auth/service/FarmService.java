package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.FarmDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.FarmInsertCommand;
import com.yuan.foodtrace.auth.domain.command.FarmUpdateCommand;
import com.yuan.foodtrace.auth.entity.FarmRecord;
import com.yuan.foodtrace.auth.mapper.FarmMapper;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    @Autowired
    FarmMapper farmMapper;

    /**
     * get the list of farm owned by operator's company.
     *
     * @param operatorCompany the company work at or onw
     * @return list of FarmRecord
     */
    public List<FarmRecord> listWithCompany(String operatorCompany) {
        return farmMapper.listWithCompany(operatorCompany);
    }


    /**
     * get list of all farm
     *
     * @return list of FarmRecord
     */
    public List<FarmRecord> list() {
        return farmMapper.list();
    }

    /**
     * insert a new farm record.
     *
     * @param command the arguments INSERT need
     * @return result of operation
     */
    public boolean insert(FarmInsertCommand command) {
        if (!_validateNameNoUse(command.getName())) {
            return false;
        }
        if (!StringUtils.equals(command.getCompany(), command.getOperatorCompany())) {
            return false;
        }
        FarmRecord record = new FarmRecord();
        record.setName(command.getName());
        if (TokenUtils.checkRoleEqualToAdmin(command.getOperatorCompany())) {
            record.setCompany(command.getCompany());
        }
        record.setCompany(command.getOperatorCompany());
        record.setLocation(command.getLocation());
        return farmMapper.insert(record) == 0 ? false : true;
    }

    /**
     * delete a farm record.
     *
     * @param command the arguments DELETE need
     * @return result of operation
     */
    public boolean delete(FarmDeleteCommand command) {
        if (!_validateIdAndCompany(command.getId(), command.getOperatorCompany())) {
            return false;
        }
        if (!_validateIdAndName(command.getId(), command.getName())) {
            return false;
        }
        return farmMapper.deleteByPrimaryKey(command.getId()) == 0 ? false : true;
    }

    /**
     * update a farm record.
     *
     * @param command a record with new value of field
     * @return result of operation
     */
    public boolean update(FarmUpdateCommand command) {
        if (!_validateIdAndCompany(command.getId(), command.getOperatorCompany())) {
            return false;
        }
        FarmRecord record = new FarmRecord();
        record.setId(command.getId());
        record.setName(command.getName());
        if (TokenUtils.checkRoleEqualToAdmin(command.getOperatorCompany())) {
            record.setCompany(command.getCompany());
        }
        record.setCompany(command.getOperatorCompany());
        record.setLocation(command.getLocation());
        return farmMapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    /**
     * to ensure `name` not be used.
     */
    private boolean _validateNameNoUse(String name) {
        FarmRecord record = farmMapper.findByName(name).orElse(new FarmRecord());
        return record.getId() == null;
    }

    /**
     * to ensure operator can only operate the record his company own.
     */
    private boolean _validateIdAndCompany(Long id, String operatorCompany) {
        FarmRecord record = farmMapper.selectByPrimaryKey(id).orElse(new FarmRecord());
        return StringUtils.equals(record.getCompany(), operatorCompany) // operator's company
                || "admin".equalsIgnoreCase(operatorCompany);   // admin
    }

    /**
     * to ensure `id` and `name` can match.
     */
    private boolean _validateIdAndName(Long id, String name) {
        FarmRecord record = farmMapper.selectByPrimaryKey(id).orElse(new FarmRecord());
        return StringUtils.equals(record.getName(), name);
    }
}
