/**
 * @author linkuan
 * @version 1.0
 * @since 2020/11/11 17:59
 */
public class MyTask implements Runnable{

    int value = -1;

    @Override
    public void run() {

        value = Homework03.sum();
    }

    public int get(){

        return value;
    }
}
