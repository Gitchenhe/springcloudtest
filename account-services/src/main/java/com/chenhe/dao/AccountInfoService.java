package com.chenhe.dao;

import com.chenhe.api.datasource.DataBaseType;
import com.chenhe.api.datasource.DataSource;
import com.chenhe.dao.entity.AccountEntity;
import com.chenhe.dao.mapper.AccountMapper;
import com.chenhe.dao.mapper.SeqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenhe
 * @Date 2018-07-26 17:01
 * @desc
 **/
@Service
public class AccountInfoService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private SeqMapper seqMapper;

    @DataSource(DataBaseType.DB_ACCOUNT)
    public AccountEntity getAccountInfo(Long accountId) {
        return accountMapper.select(accountId);
    }

    @DataSource(DataBaseType.DB_COMMON)
    public long querySeq(String name) {
        seqMapper.update(name);
        return seqMapper.querySeq(name);
    }
}
