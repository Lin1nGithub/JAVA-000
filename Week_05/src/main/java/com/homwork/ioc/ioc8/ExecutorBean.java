package src.main.java.com.homwork.ioc.ioc8;

import com.homwork.ioc.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:57
 */
@Component(value = "ioc8")
public class ExecutorBean {

    private Executor executor;

    /**
     * @Autowired 注解配置构造方法注入
     * @param executor
     */
    @Autowired
    public ExecutorBean(Executor executor) {
        this.executor = executor;
    }

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }
}
