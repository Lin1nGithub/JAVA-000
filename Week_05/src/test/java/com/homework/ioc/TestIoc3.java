package src.test.java.com.homework.ioc;

import com.homwork.ioc.ioc3.ExecutorBean;
import org.junit.Test;
import test.java.com.homework.TestBase;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:20
 */
public class TestIoc3 extends TestBase {

    public TestIoc3() {
        super("classpath*:spring-ioc3.xml");
    }

    @Test
    public void testSolution() {
        ExecutorBean outer = getBean("ioc3");
        outer.action();
    }
}
