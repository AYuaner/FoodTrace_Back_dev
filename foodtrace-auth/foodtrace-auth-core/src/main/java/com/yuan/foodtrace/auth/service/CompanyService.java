package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.CompanyDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.CompanyInsertCommand;
import com.yuan.foodtrace.auth.domain.command.CompanyUpdateCommand;
import com.yuan.foodtrace.auth.entity.CompanyRecord;
import com.yuan.foodtrace.auth.mapper.CompanyMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    /**
     * get list of all company
     *
     * @return list of CompanyRecord
     */
    public List<CompanyRecord> list() {
        return companyMapper.list();
    }

    /**
     * insert a new company record.
     *
     * @param command the arguments INSERT need
     * @return result of operation
     */
    public boolean insert(CompanyInsertCommand command) {
        if (!_validateNameNoUse(command.getName())) {
            return false;
        }
        CompanyRecord record = new CompanyRecord();
        record.setName(command.getName());
        return companyMapper.insert(record) == 0 ? false : true;
    }

    /**
     * delete a company record.
     *
     * @param command the arguments DELETE need
     * @return result of operation
     */
    public boolean delete(CompanyDeleteCommand command) {
        if (!_validateIdAndName(command.getId(), command.getName())) {
            return false;
        }
        return companyMapper.deleteByPrimaryKey(command.getId()) == 0 ? false : true;
    }

    /**
     * update a company record.
     *
     * @param command a record with new value of field
     * @return result of operation
     */
    public boolean update(CompanyUpdateCommand command) {
        CompanyRecord record = new CompanyRecord();
        record.setId(command.getId());
        record.setName(command.getName());
        return companyMapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    /**
     * to ensure `id` and `name` can match.
     */
    private boolean _validateIdAndName(Long id, String name) {
        CompanyRecord record = companyMapper.selectByPrimaryKey(id).orElse(new CompanyRecord());
        return StringUtils.equals(record.getName(), name);
    }

    /**
     * to ensure `name` not be used.
     */
    private boolean _validateNameNoUse(String name) {
        CompanyRecord record = companyMapper.findByName(name).orElse(new CompanyRecord());
        return record.getId() == null;
    }
}
