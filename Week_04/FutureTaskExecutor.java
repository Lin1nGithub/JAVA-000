import java.util.concurrent.FutureTask;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/11 17:41
 */
public class FutureTaskExecutor implements Executor {

    @Override
    public int execute()throws Exception{
        FutureTask<Integer> task = new FutureTask<>(Homework03::sum);

        new Thread(task).start();
        return task.get();
    }
}
