package src.main.java.com.homwork.ioc.ioc2;

import com.homwork.ioc.Executor;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:35
 */
public class ExecutorBean {

    private Executor executor;

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }

    /**
     * 装配方案2
     * 在XML中配置executor字段用构造器方法进行注入，对应xml文件为spring-ioc2.xml
     * @param executor
     */
    public ExecutorBean(Executor executor) {
        this.executor = executor;
    }
}
