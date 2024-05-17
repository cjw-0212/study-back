package assist;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author CJW
 * @since 2024/3/15
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        /**
         * 六辆汽车抢占三个车位
         */
        Semaphore semaphore=new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println("-----------------"+Thread.currentThread().getName()+"离开了车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }
    }
}
