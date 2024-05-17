package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CJW
 * @since 2024/3/8
 */
public class Communication {
    public static void main(String[] args) {
        Share share=new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"D").start();
    }
}
class Share{
    private int number;
    Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+" "+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (number!=1){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+" "+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
