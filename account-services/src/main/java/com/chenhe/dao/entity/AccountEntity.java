package com.chenhe.dao.entity;

/**
 * @author chenhe
 * @Date 2018-07-26 15:50
 * @desc
 **/
public class AccountEntity {
    private Long accountId;
    private String accountType;
    private String accountName;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
