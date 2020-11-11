import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/11 17:51
 */
public class CountDownLatchExecutor implements Executor{
    @Override
    public int execute() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        MyTask task = new MyTask();
        new Thread(task).start();
        countDownLatch.await();
        return task.get();
    }

}
