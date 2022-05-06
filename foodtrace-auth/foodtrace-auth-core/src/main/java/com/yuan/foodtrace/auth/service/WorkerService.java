package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.WorkerDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerInsertCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerUpdateCommand;
import com.yuan.foodtrace.auth.domain.dto.WorkerDTO;
import com.yuan.foodtrace.auth.domain.request.WorkerInsertRequest;
import com.yuan.foodtrace.auth.entity.FarmRecord;
import com.yuan.foodtrace.auth.entity.WorkerRecord;
import com.yuan.foodtrace.auth.mapper.WorkerMapper;
import com.yuan.foodtrace.auth.utils.MapperUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerMapper mapper;

    /**
     * get the list of farm owned by operator's company.
     *
     * @param operatorCompany the company work at or onw
     * @return list of WorkerRecord
     */
    public List<WorkerRecord> listWithCompany(String operatorCompany) {
        return mapper.listWithCompany(operatorCompany);
    }

    /**
     * get list of all farm
     *
     * @return list of WorkerRecord
     */
    public List<WorkerRecord> list() {
        return mapper.list();
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
        record.setCompany(command.getCompany());
        return mapper.insert(record) == 0 ? false : true;
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
        return mapper.deleteByPrimaryKey(command.getId()) == 0 ? false : true;
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
        record.setCompany(command.getCompany());
        return mapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    /**
     * to ensure `id number` not exist.
     */
    private boolean _validateIdNumberNoExist(String idNumber) {
        WorkerRecord record = mapper.findByIdNumber(idNumber).orElse(new WorkerRecord());
        return record.getId() == null;
    }

    /**
     * to ensure `id` and `id number` can match.
     */
    private boolean _validateIdAndIdNumber(Long id, String idNumber) {
        WorkerRecord record = mapper.selectByPrimaryKey(id).orElse(new WorkerRecord());
        return StringUtils.equals(record.getIdNumber(), idNumber);
    }

    /**
     * to ensure operator can only operate the record his company own.
     */
    private boolean _validateIdAndCompany(Long id, String operatorCompany) {
        WorkerRecord record = mapper.selectByPrimaryKey(id).orElse(new WorkerRecord());
        return StringUtils.equals(record.getCompany(), operatorCompany)
                || "admin".equalsIgnoreCase(operatorCompany);
    }
}
