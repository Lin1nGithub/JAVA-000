package src.test.java.com.homework.aop;

import com.homwork.aop.*;
import org.junit.Test;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:17
 */
public class TestAop {

    @Test
    public void testDynamicProxyAOP() {
        DemoExecutor obj1 = new DemoExecutor();
        DemoExecutor2 obj2 = new DemoExecutor2();

        Executor aopObj1 = (Executor) DynamicProxyAOP.getProxy(obj1, Executor.class, new DemoInterceptor());
        Executor aopObj2 = (Executor)DynamicProxyAOP.getProxy(obj2, Executor.class, new DemoInterceptor());

        aopObj1.execute();
        aopObj2.execute();
    }
}
