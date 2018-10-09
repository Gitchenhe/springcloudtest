package com.chenhe.api.datasource;


/**
 * @author chenhe
 * @Date 2018-07-26 16:24
 * @desc 作用: 保存一个线程安全的DatabaseType容器
 **/
public class DatabaseContextHolder {

    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DataBaseType databaseType) {

        contextHolder.set(databaseType);
    }

    public static DataBaseType getDataBaseType() {
        return contextHolder.get();
    }
}
