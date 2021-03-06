package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.WorkerDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerInsertCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerUpdateCommand;
import com.yuan.foodtrace.auth.entity.WorkerRecord;
import com.yuan.foodtrace.auth.mapper.WorkerMapper;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerMapper workerMapper;

    /**
     * get the list of farm owned by operator's company.
     *
     * @param operatorCompany the company work at or onw
     * @return list of WorkerRecord
     */
    public List<WorkerRecord> listWithCompany(String operatorCompany) {
        return workerMapper.listWithCompany(operatorCompany);
    }

    /**
     * get list of all farm
     *
     * @return list of WorkerRecord
     */
    public List<WorkerRecord> list() {
        return workerMapper.list();
    }

    /**
     * insert a new worker record.
     *
     * @param command the arguments INSERT need
     * @return result of operation
     */
    public boolean insert(WorkerInsertCommand command) {
        if (!_validateIdNumberNoExist(command.getIdNumber())) {
            return false;
        }
        WorkerRecord record = new WorkerRecord();
        record.setName(command.getName());
        record.setIdNumber(command.getIdNumber());
        record.setPhoneNumber(command.getPhoneNumber());
        record.setAge(command.getAge());
        record.setGender(command.getGender());
        if (TokenUtils.checkRoleEqualToAdmin(command.getOperatorCompany())) {
            record.setCompany(command.getCompany());
        }
        record.setCompany(command.getOperatorCompany());
        return workerMapper.insert(record) == 0 ? false : true;
    }

    /**
     * delete a worker record.
     *
     * @param command the arguments DELETE need
     * @return result of operation
     */
    public boolean delete(WorkerDeleteCommand command) {
        if (!_validateIdAndCompany(command.getId(), command.getOperatorCompany())) {
            return false;
        }
        if (!_validateIdAndIdNumber(command.getId(), command.getIdNumber())) {
            return false;
        }
        return workerMapper.deleteByPrimaryKey(command.getId()) == 0 ? false : true;
    }

    /**
     * update a worker record.
     *
     * @param command a record with new value of field
     * @return result of operation
     */
    public boolean update(WorkerUpdateCommand command) {
        if (!_validateIdAndCompany(command.getId(), command.getOperatorCompany())) {
            return false;
        }
        WorkerRecord record = new WorkerRecord();
        record.setId(command.getId());
        record.setName(command.getName());
        record.setIdNumber(command.getIdNumber());
        record.setPhoneNumber(command.getPhoneNumber());
        record.setAge(command.getAge());
        record.setGender(command.getGender());
        if (TokenUtils.checkRoleEqualToAdmin(command.getOperatorCompany())) {
            record.setCompany(command.getCompany());
        }
        record.setCompany(command.getOperatorCompany());
        return workerMapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    /**
     * to ensure `id number` not exist.
     */
    private boolean _validateIdNumberNoExist(String idNumber) {
        WorkerRecord record = workerMapper.findByIdNumber(idNumber).orElse(new WorkerRecord());
        return record.getId() == null;
    }

    /**
     * to ensure `id` and `id number` can match.
     */
    private boolean _validateIdAndIdNumber(Long id, String idNumber) {
        WorkerRecord record = workerMapper.selectByPrimaryKey(id).orElse(new WorkerRecord());
        return StringUtils.equals(record.getIdNumber(), idNumber);
    }

    /**
     * to ensure operator can only operate the record his company own.
     */
    private boolean _validateIdAndCompany(Long id, String operatorCompany) {
        WorkerRecord record = workerMapper.selectByPrimaryKey(id).orElse(new WorkerRecord());
        return StringUtils.equals(record.getCompany(), operatorCompany)
                || "admin".equalsIgnoreCase(operatorCompany);
    }
}
