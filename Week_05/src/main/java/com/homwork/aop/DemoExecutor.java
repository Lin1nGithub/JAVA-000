package src.main.java.com.homwork.aop;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/18 20:08
 */
public class DemoExecutor implements Executor{

    @Override
    public void execute() {
        System.out.println("DemoExecutor execute");
    }
}
