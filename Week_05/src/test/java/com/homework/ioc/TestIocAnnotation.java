package src.test.java.com.homework.ioc;

import com.homwork.ioc.Executor;
import com.homwork.ioc.ioc5.ExecutorBean;
import org.junit.Test;
import test.java.com.homework.TestBase;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:32
 */
public class TestIocAnnotation extends TestBase {

    public TestIocAnnotation() {
        super("classpath*:spring-annotation.xml");
    }

    @Test
    public void test5() {
        ExecutorBean executorBean = getBean("ioc5");
        executorBean.action();
    }

    @Test
    public void test6() {
        com.homwork.ioc.ioc6.ExecutorBean executorBean = getBean("ioc6");
        executorBean.action();
    }

    @Test
    public void test7() {
        com.homwork.ioc.ioc7.ExecutorBean outer = getBean("ioc7");
        outer.action();
    }

    @Test
    public void test8() {
        com.homwork.ioc.ioc8.ExecutorBean outer = getBean("ioc8");
        outer.action();
    }

    @Test
    public void test9() {
        com.homwork.ioc.ioc9.ExecutorBean outer = getBean("ioc9");
        outer.action();
    }
}
