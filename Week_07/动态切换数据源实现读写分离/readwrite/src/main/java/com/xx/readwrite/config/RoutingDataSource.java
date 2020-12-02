package com.xx.readwrite.config;

import com.xx.readwrite.config.holder.DataSourceContextHolder;
import com.xx.readwrite.config.util.LoadBalancerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;
import java.util.Random;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:05
 */
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    private List<String> slaveDataSourceKeys;

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceRoutingKey dataSourceRoutingKey = DataSourceContextHolder.getDataSourceRoutingKey();
        if (dataSourceRoutingKey.equals(DataSourceRoutingKey.WRITE)) {
            log.info("向主库写操作");
            return dataSourceRoutingKey;
        }
        return getReadKeyBalancing();
    }

    private String getReadKeyBalancing() {
        // 轮询在列表中获取从库的 key
        String readKey = slaveDataSourceKeys.get(LoadBalancerUtil.roundRule(slaveDataSourceKeys.size()));
        log.info("轮询在列表中获取从库的 key:{}",readKey);
        return readKey;
    }

    public void setSlaveDataSourceKeys(List<String> slaveDataSourceKeys) {
        this.slaveDataSourceKeys = slaveDataSourceKeys;
    }
}
