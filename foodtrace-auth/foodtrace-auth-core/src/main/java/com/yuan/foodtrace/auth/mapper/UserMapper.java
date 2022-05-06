package com.yuan.foodtrace.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author A_Yuan
 */
@Mapper
public interface UserMapper extends UserBaseMapper {

    /**
     * 通过用户名查找
     *
     * @param username 用户名
     * @return 找到的用户
     */
    default Optional<UserRecord> findByUsername(String username) {
        return selectOne(c -> c.where(UserRecordDynamicSqlSupport.username, isEqualTo(username)));
    }

    /**
     * 通过ID查找
     *
     * @param id ID
     * @return 找到的用户
     */
    default Optional<UserRecord> findUserById(Long id) {
        return selectOne(c -> c.where(UserRecordDynamicSqlSupport.id, isEqualTo(id)));
    }

}
