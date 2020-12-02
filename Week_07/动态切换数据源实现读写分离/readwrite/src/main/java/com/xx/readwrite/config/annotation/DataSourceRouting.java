package com.xx.readwrite.config.annotation;

import com.xx.readwrite.config.DataSourceRoutingKey;

import java.lang.annotation.*;

/**
 * 通过自定义注解和切面编程实现根据注解切换使用的数据源
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DataSourceRouting {

    DataSourceRoutingKey value() default DataSourceRoutingKey.WRITE;
}
