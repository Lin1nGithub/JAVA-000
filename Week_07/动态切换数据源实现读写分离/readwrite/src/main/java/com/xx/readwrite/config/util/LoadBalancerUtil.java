package com.xx.readwrite.config.util;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 负载均衡，参考ribbon的算法机制
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 15:25
 */
public class LoadBalancerUtil {

    private final static Random rand;

    private final static AtomicInteger nextCyclicCounter;

    static {
        rand = new Random();
        nextCyclicCounter = new AtomicInteger(0);
    }

    /**
     * 随机算法
     *
     * @param number 随机数的上线
     * @return 返回 0 ~ (number-1) 的随机数
     */
    public static int randomRule(int number) {
        return rand.nextInt(number);
    }

    /**
     * 轮巡算法
     *
     * @param modulo 取余的阔值
     * @return 当前轮巡的数值
     */
    public static int roundRule(int modulo) {
        int current;
        int next;
        do {
            current = nextCyclicCounter.get();
            next = (current + 1) % modulo;
        } while (!nextCyclicCounter.compareAndSet(current, next));
        return next;
    }
}
