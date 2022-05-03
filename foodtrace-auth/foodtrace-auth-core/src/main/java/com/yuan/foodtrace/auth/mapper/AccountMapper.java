package com.yuan.foodtrace.auth.mapper;

import com.yuan.foodtrace.auth.dao.UserBaseMapper;
import com.yuan.foodtrace.auth.entity.UserRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

import static com.yuan.foodtrace.auth.dao.UserRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @author A_Yuan
 */
@Mapper
public interface AccountMapper extends UserBaseMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    default List<UserRecord> list() {
        return select(c -> c);
    }

    /**
     * 修改某一用户的启用状态
     *
     * @param user 新用户信息对象
     * @return 是否操作成功
     */
    default int updateEnableState(UserRecord user) {
        return update(c ->
                c.set(enable).equalTo(user::getEnable)
                .where(id, isEqualTo(user::getId)));
    }

    /**
     * 通过用户名查找
     *
     * @param queryUsername 用户名
     * @return 找到的用户
     */
    default Optional<UserRecord> findByUsername(String queryUsername) {
        return selectOne(c -> c.where(username, isEqualTo(queryUsername)));
    }

}
