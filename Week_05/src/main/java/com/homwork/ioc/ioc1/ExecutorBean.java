package src.main.java.com.homwork.ioc.ioc1;

import com.homwork.ioc.Executor;
import com.homwork.ioc.ExecutorImpl;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:23
 */
public class ExecutorBean {

    private Executor executor;

    public void action() {
        System.out.println("testing " + this.getClass().getName());
        executor.execute();
    }

    /**
     * 装配方案1
     * 在XML中配置executor字段用setter方法进行注入，对应xml文件为spring-ioc1.xml
     * @param impl
     */
    public void setExecutor(ExecutorImpl impl) {
        this.executor = impl;
    }
}
