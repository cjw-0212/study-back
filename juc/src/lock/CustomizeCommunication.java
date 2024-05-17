package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CJW
 * @since 2024/3/8
 */
public class CustomizeCommunication {
    public static void main(String[] args) {
        Resource resource=new Resource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.printA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"打印A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.printB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"打印B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.printC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"打印C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.printC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"打印C").start();
    }
}

class Resource {
    //标志位
    private int flag=1;
    Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (flag!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+":A");
            flag=2;
            condition2.signal();
        }  finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (flag!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+":B");
            flag=3;
            condition3.signal();
        }  finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (flag!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+":C");
            flag=1;
            condition1.signal();
        }  finally {
            lock.unlock();
        }
    }
}
