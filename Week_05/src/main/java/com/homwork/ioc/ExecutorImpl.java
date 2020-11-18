package src.main.java.com.homwork.ioc;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 19:25
 */
public class ExecutorImpl implements Executor{

    @Override
    public void execute() {
        System.out.println("impl execute");
    }
}
