package src.main.java.com.homwork.ioc.ioc6;

import com.homwork.ioc.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:55
 */
@Component(value = "ioc6")
public class ExecutorBean {

    private Executor executor;

    /**
     * 通过setter方法 自动注入
     */
    @Autowired
    public void setInnerObj(Executor executor) {
        this.executor = executor;
    }

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }
}
