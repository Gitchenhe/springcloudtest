package com.chenhe.api.datasource;

import java.lang.annotation.*;

/**
 * @author chenhe
 * @Date 2018-07-27 10:20
 * @desc
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    /**
     * 使用的数据源
     * @return
     */
    DataBaseType value();
}
