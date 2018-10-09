package com.chenhe.dao.mapper;

import com.chenhe.dao.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.sql.JDBCType;

/**
 * @author chenhe
 * @Date 2018-07-26 15:50
 * @desc
 **/
public interface AccountMapper {

    @Select("select * from t_accountinfo WHERE account_id = #{accountId}")
    @Results(value = {@Result(id = true, column = "account_id", property = "accountId", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(column = "account_type", property = "accountType", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(column = "account_name", property = "accountName", jdbcType = JdbcType.VARCHAR, javaType = String.class)}
    )
    AccountEntity select(@Param("accountId") long accountId);
}
