package com.chenhe.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



/**
 * @author chenhe
 * @Date 2018-07-27 10:49
 * @desc
 **/
@Aspect
@Component
public class DataSourceFilter {
    @Before("@annotation(com.chenhe.api.datasource.DataSource)")
    public void before(JoinPoint joinPoint){
        joinPoint.getSignature().getName();

    }
}
