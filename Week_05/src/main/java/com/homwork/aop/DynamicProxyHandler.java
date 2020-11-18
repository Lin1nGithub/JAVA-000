package src.main.java.com.homwork.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:05
 */
public class DynamicProxyHandler  implements InvocationHandler {

    Object realObj = null;
    Interceptor interceptor = null;

    public DynamicProxyHandler(Object proxed, Interceptor interceptor) {
        realObj = proxed;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object ret = null;

        interceptor.before(realObj, method, args);
        try {
            ret = interceptor.around(realObj, method, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            interceptor.after(realObj, method, args);
        }

        return ret;
    }
}
