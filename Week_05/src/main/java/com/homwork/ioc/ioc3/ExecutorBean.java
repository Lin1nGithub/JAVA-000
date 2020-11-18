package src.main.java.com.homwork.ioc.ioc3;

import com.homwork.ioc.Executor;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:38
 */
public class ExecutorBean {

    private Executor executor;

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }

    /**
     * 装配方案3
     * 在XML中配置自动注入bean 对应xml文件为spring-ioc3.xml
     * @param executor
     */
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

}
