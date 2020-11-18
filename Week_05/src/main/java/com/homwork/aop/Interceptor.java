package src.main.java.com.homwork.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:06
 */
public interface Interceptor {

    void before(Object obj, Method method, Object[] args);       // 前向拦截接口

    void after(Object obj, Method method, Object[] args);        // 后向拦截接口

    // 环绕拦截器接口，默认时间就是对方法进行调用
    default Object around(Object obj, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(obj, args);
    }
}
