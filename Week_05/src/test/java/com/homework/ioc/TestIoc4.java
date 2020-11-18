package src.test.java.com.homework.ioc;

import com.homwork.ioc.ioc4.ExecutorBean;
import org.junit.Test;
import test.java.com.homework.TestBase;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:20
 */
public class TestIoc4 extends TestBase {

    public TestIoc4() {
        super("classpath*:spring-ioc4.xml");
    }

    @Test
    public void testSolution() {
        ExecutorBean outer = getBean("ioc4");
        outer.action();
    }
}
