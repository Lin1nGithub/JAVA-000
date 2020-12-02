package com.xx.readwrite.config.aspect;

import com.xx.readwrite.config.annotation.DataSourceRouting;
import com.xx.readwrite.config.holder.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:10
 */
@Component
@Aspect
public class DataSourceRoutingAspect {

    @Before("@annotation(com.xx.readwrite.config.annotation.DataSourceRouting)")
    public void before(JoinPoint point) {
        // 获取切点方法
        Method method = ((MethodSignature)point.getSignature()).getMethod();
        DataSourceRouting annotation = method.getAnnotation(DataSourceRouting.class);
        DataSourceContextHolder.setDataSourceRoutingKey(annotation.value());
    }

    @After("@annotation(com.xx.readwrite.config.annotation.DataSourceRouting)")
    public void after() {
        DataSourceContextHolder.clearDataSourceRoutingKey();
    }
}
