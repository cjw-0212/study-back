package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CJW
 * @since 2024/3/5
 */
public class Lticket {
    private int number=30;

    //非公平锁执行效率高，但是可能造成线程饿死的情况
    //公平锁雨露均沾每个线程都有活干，效率低一点
    private final ReentrantLock lock=new ReentrantLock(true);
    public void sale(){
        lock.lock();
        try {
            if (number>0){
                number--;
                System.out.println(Thread.currentThread().getName()+"卖出一张  剩余票数："+number);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //由于出现异常不会自动释放锁，需要放在finally块中，不然会导致死锁
            lock.unlock();
        }
    }
}
