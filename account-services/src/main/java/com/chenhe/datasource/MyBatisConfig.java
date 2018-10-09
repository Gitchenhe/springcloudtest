package com.chenhe.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.chenhe.api.datasource.DataBaseType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author chenhe
 * @Date 2018-07-26 16:29
 * @desc springBoot 继承Mybatis的基本入口
 * 1. 创建数据源
 * 2.创建SQLSessionFactory
 * 3.配置事务管理器,除非需要使用事务,否则不用配置
 **/
@Configuration
@MapperScan(basePackages = "com.chenhe.dao.mapper")
public class MyBatisConfig {

    private Logger LOGGER = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    private Environment environment;

    @Bean(name = "dbAccount")
    public DataSource accountDataSource() {

        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc1.driverClassName"));
        properties.put("url", environment.getProperty("jdbc1.url"));
        properties.put("username", environment.getProperty("jdbc1.username"));
        properties.put("password", environment.getProperty("jdbc1.password"));

        LOGGER.info("创建数据源 dbAccount -> {}", properties);

        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            LOGGER.error("账户数据源创建异常", e);
        }
        return null;
    }

    @Bean(name = "dbCommon")
    public DataSource commonDataSource() {

        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc2.driverClassName"));
        properties.put("url", environment.getProperty("jdbc2.url"));
        properties.put("username", environment.getProperty("jdbc2.username"));
        properties.put("password", environment.getProperty("jdbc2.password"));
        LOGGER.info("创建数据源 dbCommon -> {}", properties);
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            LOGGER.error("公共数据源创建异常", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param accountDataSource
     * @param commonDataSource
     * @return
     * @Primary 该注解表示在同一个几口有多个实现类可以注入的时候, 默认选哪一个, 而不是@autowire 报错
     */
    @Bean(name ="dynamicDataSource" )
    @Primary
    public DynamicDataSource dynamicDataSource(@Qualifier("dbAccount") DataSource accountDataSource, @Qualifier("dbCommon") DataSource commonDataSource) {
        LOGGER.info("创建动态数据源 DynamicDataSource ");
        Map<Object, Object> targetDataSource = new HashMap<>(4);
        targetDataSource.put(DataBaseType.DB_ACCOUNT, accountDataSource);
        targetDataSource.put(DataBaseType.DB_COMMON, commonDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(accountDataSource);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource) {
        LOGGER.info("创建SQLSessionFactory");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));

        try {
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapperLocations")));
            return sqlSessionFactoryBean.getObject();
        } catch (IOException e) {
            LOGGER.error("创建 SqlSessionFactory出错, 查找mapper路径异常", e);
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.error("创建 SqlSessionFactory出错", e);
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) {
        LOGGER.info("创建 DataSourceTransactionManager");
        return new DataSourceTransactionManager(dataSource);
    }

}
