package src.main.java.com.homwork.aop;

import java.lang.reflect.Proxy;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:05
 */
public class DynamicProxyAOP {
    public static Object getProxy (Object obj, Class interfaceClass, Interceptor interceptor) {
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{interfaceClass},
                new DynamicProxyHandler(obj, interceptor));
    }
}
