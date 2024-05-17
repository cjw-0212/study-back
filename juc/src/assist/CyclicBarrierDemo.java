package assist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author CJW
 * @since 2024/3/15
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 集齐七龙珠召唤神龙
         */
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            //当等待数量达到7就会执行这个方法
            System.out.println("集齐龙珠召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"龙珠");
                //增加一个等待，如果全部达不到七个就会一直等待
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }
    }
}
