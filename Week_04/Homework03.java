/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/11 17:35
 */
public class Homework03 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        int result = -1;
        try {

            // int result = sum(); //这是得到的返回值

            // futureTask
//        FutureTaskExecutor executor = new FutureTaskExecutor();
//        int result = executor.execute();

//            CompletableFutureExecutor executor = new CompletableFutureExecutor();
//            result = executor.execute();


//            CountDownLatchExecutor executor =new CountDownLatchExecutor();
//            result = executor.execute();



        }catch (Exception e){

            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
