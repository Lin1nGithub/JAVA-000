package com.xx.readwrite.config.holder;

import com.xx.readwrite.config.DataSourceRoutingKey;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 14:56
 */
@Slf4j
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceRoutingKey> ROUTING_KEY = new ThreadLocal<>();

    public static void setDataSourceRoutingKey(DataSourceRoutingKey key) {
        log.info("修改数据源路由标识为:{}", key);
        ROUTING_KEY.set(key);
    }

    public static DataSourceRoutingKey getDataSourceRoutingKey() {
        return ROUTING_KEY.get();
    }

    public static void clearDataSourceRoutingKey() {
        ROUTING_KEY.remove();
    }
}
