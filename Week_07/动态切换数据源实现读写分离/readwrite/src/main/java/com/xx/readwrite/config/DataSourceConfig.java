package com.xx.readwrite.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 14:31
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.replica")
    DataSource replicaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "routingDataSource")
    DataSource dataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("slaveDataSource") DataSource slaveDataSource,
                          @Qualifier("replicaDataSource") DataSource replicaDataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>(8);
        targetDataSource.put(DataSourceRoutingKey.WRITE, masterDataSource);
        targetDataSource.put("slaveDataSource", slaveDataSource);
        targetDataSource.put("replicaDataSource", replicaDataSource);
        List<String> slaveKeys = new ArrayList<>(2);
        slaveKeys.add("slaveDataSource");
        slaveKeys.add("replicaDataSource");
        RoutingDataSource dataSource = new RoutingDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        // 设置从库的 key列表
        dataSource.setSlaveDataSourceKeys(slaveKeys);
        dataSource.setDefaultTargetDataSource(masterDataSource);
        return dataSource;
    }
}
