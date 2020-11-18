package src.main.java.com.homwork.ioc.ioc4;

import com.homwork.ioc.Executor;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:46
 */
public class ExecutorBean {

    private Executor executor;

    /**
     * XML 配置 beans 标签中 default-autowire 为constructor, 用Outer的构造函数进行注入
     * @param executor
     */
    public ExecutorBean(Executor executor) {
        this.executor = executor;
    }

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }
}
