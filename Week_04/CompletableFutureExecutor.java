import java.util.concurrent.CompletableFuture;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/11 17:47
 */
public class CompletableFutureExecutor implements Executor{

    @Override
    public int execute() throws Exception{
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(Homework03::sum);
        return completableFuture.get();
    }
}
