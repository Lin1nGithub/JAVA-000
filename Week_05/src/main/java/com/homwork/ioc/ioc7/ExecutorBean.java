package src.main.java.com.homwork.ioc.ioc7;

import com.homwork.ioc.Executor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:56
 */
@Component(value = "ioc7")
public class ExecutorBean {

    /**
     * 使用@Resource注解进行字段注入
     */
    @Resource(name= "Autowire")
    private Executor executor;

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }
}
