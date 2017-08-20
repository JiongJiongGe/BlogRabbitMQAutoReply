package com.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *  Druid 连接池
 */

@Configuration
public class DruidConfig {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public DataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver,
                                      @Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.username}") String username,
                                      @Value("${spring.datasource.password}") String password) {

        try {
            logger.info("init DruidConfig. url={}",url);
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName(driver);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setFilters(env.getProperty("spring.datasource.filters"));
            druidDataSource.setInitialSize(Integer.valueOf(env.getProperty("spring.datasource.initialSize")));
            druidDataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
            druidDataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
            druidDataSource.setMaxActive(Integer.valueOf(env.getProperty("spring.datasource.maxActive")));
            druidDataSource.setMinIdle(Integer.valueOf(env.getProperty("spring.datasource.minIdle")));
            druidDataSource.setMinIdle(Integer.valueOf(env.getProperty("spring.datasource.maxIdle")));
            druidDataSource.setMaxWait(Integer.valueOf(env.getProperty("spring.datasource.maxWait")));
            druidDataSource.setValidationQuery(env.getProperty("spring.datasource.validationQuery"));
            druidDataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("spring.datasource.validationQuery")));
            druidDataSource.setTestOnReturn(Boolean.valueOf(env.getProperty("spring.datasource.testOnReturn")));
            druidDataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("spring.datasource.testWhileIdle")));
            druidDataSource.setPoolPreparedStatements(Boolean.valueOf(env.getProperty("spring.datasource.poolPreparedStatements")));
            druidDataSource.setMaxOpenPreparedStatements(Integer.valueOf(env.getProperty("spring.datasource.maxOpenPreparedStatements")));
            druidDataSource.setFilters(env.getProperty("spring.datasource.filters"));
            druidDataSource.setRemoveAbandoned(Boolean.valueOf(env.getProperty("spring.datasource.removeAbandoned")));
            druidDataSource.setRemoveAbandonedTimeout(Integer.valueOf(env.getProperty("spring.datasource.removeAbandonedTimeout")));
            druidDataSource.setLogAbandoned(Boolean.valueOf(env.getProperty("spring.datasource.logAbandoned")));
            druidDataSource.setConnectionInitSqls(Lists.newArrayList(env.getProperty("spring.datasource.connectionInitSqls")));

            return druidDataSource;

        } catch (SQLException e) {
            logger.error("init druidDataSource exception!",e);
        }
        return null;
    }

}
