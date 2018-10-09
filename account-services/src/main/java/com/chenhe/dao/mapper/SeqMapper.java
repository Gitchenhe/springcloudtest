package com.chenhe.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @author chenhe
 * @Date 2018-07-26 17:43
 * @desc
 **/
public interface SeqMapper {
    @Select("select value from t_seq where seq_name = #{seqName} ")
    @ResultType(Long.class)
    long querySeq(@Param("seqName") String name);

    @Update("update t_seq set value = value + 1")
    void update(@Param("seqName") String name);
}
