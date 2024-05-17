package assist;

import java.util.concurrent.CountDownLatch;

/**
 * @author CJW
 * @since 2024/3/15
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 等待所有同学离开教室然后关门
         */
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开教室");
                //计数减一
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //如果计数大于零会一直在此处等待
        countDownLatch.await();
        System.out.println("锁门");
    }
}
