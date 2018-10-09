package com.chenhe.datasource;

import com.chenhe.api.datasource.DataBaseType;
import com.chenhe.api.datasource.DatabaseContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author chenhe
 * @Date 2018-07-26 16:27
 * @desc 动态数据源(需要继承 AbstractRoutingDataSource)
 **/
public class DynamicDataSource extends AbstractRoutingDataSource{
    private Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        DataBaseType dataBaseType = DatabaseContextHolder.getDataBaseType();
        logger.info("当前数据源: {}", dataBaseType);
        return dataBaseType;
    }
}
