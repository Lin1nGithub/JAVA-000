package src.main.java.com.homwork.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:21
 */
public class DemoInterceptor implements Interceptor{

    @Override
    public void before(Object obj, Method method, Object[] args) {
        System.out.println("before, " + obj + "." + method.getName());
    }

    @Override
    public void after(Object obj, Method method, Object[] args) {
        System.out.println("after, " + obj + "." + method.getName());
    }

    @Override
    public Object around(Object obj, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around1, " + obj + "." + method.getName());
        Object ret = method.invoke(obj, args);
        System.out.println("around2, " + obj + "." + method.getName());

        return ret;
    }
}
