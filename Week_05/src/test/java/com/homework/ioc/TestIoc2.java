package src.test.java.com.homework.ioc;

import com.homwork.ioc.ioc2.ExecutorBean;
import org.junit.Test;
import test.java.com.homework.TestBase;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:20
 */
public class TestIoc2 extends TestBase {

    public TestIoc2() {
        super("classpath*:spring-ioc2.xml");
    }

    @Test
    public void testSolution() {
        ExecutorBean outer = getBean("ioc2");
        outer.action();
    }
}
