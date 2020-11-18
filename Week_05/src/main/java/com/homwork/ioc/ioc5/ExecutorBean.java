package src.main.java.com.homwork.ioc.ioc5;

import com.homwork.ioc.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:53
 */
@Component(value = "ioc5")
public class ExecutorBean {

    /**
     * 自动注入
     */
    @Autowired
    private Executor executor;

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }
}
