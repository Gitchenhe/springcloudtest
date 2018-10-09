package com.chenhe.controller;

import com.chenhe.dao.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenhe
 * @Date 2018-07-26 17:03
 * @desc
 **/
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping("accountInfo/{id}")
    public Object accountInfo(@PathVariable("id") Long id) {
        return accountInfoService.getAccountInfo(id);
    }

    @RequestMapping("seq/{name}")
    public Object querySeq(@PathVariable("name") String name) {
        return accountInfoService.querySeq(name);

    }
}
