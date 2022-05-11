package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.domain.command.AccountDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.AccountInsertCommand;
import com.yuan.foodtrace.auth.domain.command.AccountUpdateCommand;
import com.yuan.foodtrace.auth.entity.UserRecord;
import com.yuan.foodtrace.auth.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号管理相关服务
 *
 * @author A_Yuan
 */
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    /**
     * 查询列表
     *
     * @return 查询列表数据
     */
    public List<UserRecord> list() {
        return accountMapper.list();
    }

    /**
     * 启用？弃用账号
     *
     * @param command 账号信息 id enable
     * @return 修改结果
     */
    public Boolean delete(AccountDeleteCommand command) {
        if (!_validateIdAndUsername(command.getId(), command.getUsername())) {
            return false;
        }
        UserRecord record = new UserRecord();
        record.setId(command.getId());
        record.setEnable(command.isEnable());
        return accountMapper.updateEnableState(record) == 0 ? false : true;
    }

    /**
     * 新建一个用户
     *
     * @param command 新用户信息（不包括id）
     * @return 插入结果
     */
    public Boolean insert(AccountInsertCommand command) {
        if (!_validateUsernameNoUse(command.getUsername())) {
            return false;
        }
        UserRecord record = new UserRecord();
        record.setUsername(command.getUsername());
        record.setPassword(command.getPassword());
        record.setRole(command.getRole());
        record.setCompany(command.getCompany());
        record.setEnable(true);
        return accountMapper.insert(record) == 0 ? false : true;
    }

    /**
     * 更新用户信息
     *
     * @param command 更新后的用户信息
     * @return 更新结果
     */
    public Boolean update(AccountUpdateCommand command) {
        if (!_validateId(command.getId())) {
            return false;
        }

        UserRecord record = new UserRecord();
        record.setId(command.getId());
        record.setUsername(command.getUsername());
        record.setPassword(command.getPassword());
        record.setRole(command.getRole());
        record.setCompany(command.getCompany());
        return accountMapper.updateByPrimaryKeySelective(record) == 0 ? false : true;
    }

    private boolean _validateUsernameNoUse(String username) {
        UserRecord record = accountMapper.findByUsername(username).orElse(new UserRecord());
        return record.getId() == null;
    }

    private boolean _validateIdAndUsername(Long id, String username) {
        UserRecord queryUser = accountMapper.selectByPrimaryKey(id).orElse(new UserRecord());
        return queryUser.getUsername().equals(username);
    }

    private boolean _validateId(Long id) {
        UserRecord record = accountMapper.selectByPrimaryKey(id).orElse(new UserRecord());
        return record.getId() != null;
    }
}
