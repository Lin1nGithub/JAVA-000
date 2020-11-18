package src.test.java.com.homework.ioc;

import com.homwork.ioc.ioc1.ExecutorBean;
import org.junit.Test;
import test.java.com.homework.TestBase;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:20
 */
public class TestIoc1 extends TestBase {

    public TestIoc1() {
        super("classpath*:spring-ioc1.xml");
    }

    @Test
    public void testSolution() {
        ExecutorBean outer = getBean("ioc1");
        outer.action();
    }
}
