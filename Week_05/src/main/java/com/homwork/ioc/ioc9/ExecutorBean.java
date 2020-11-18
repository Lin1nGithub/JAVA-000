package src.main.java.com.homwork.ioc.ioc9;

import com.homwork.ioc.Executor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:57
 */
@Component(value = "ioc9")
public class ExecutorBean {

    private Executor executor;

    /**
     * 使用@Resource注解进行setter注入
     * @param executor
     */
    @Resource(name="Autowire")
    public void setInner(Executor executor) {
        this.executor = executor;
    }

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }

}
