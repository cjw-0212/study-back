package readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author CJW
 * @since 2024/3/16
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            String num = String.valueOf(i);
            new Thread(() -> {
                myCache.put(num, num);
            }, num).start();
        }
        for (int i = 0; i < 5; i++) {
            String num = String.valueOf(i);
            new Thread(() -> {
                myCache.get(num);
            }, num).start();
        }
    }
}

class MyCache {
    private volatile Map<String, String> map = new HashMap<>();
    //写锁是独占锁，读锁是共享锁
    //写的时候可以读，读的时候不能写
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写数据" + key + ":" + value);
            TimeUnit.MICROSECONDS.sleep(100);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "    写完数据" + key + ":" + value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println("----------------------------" + Thread.currentThread().getName() + "正在读数据" + key);
            TimeUnit.MICROSECONDS.sleep(100);
            String s = map.get(key);
            System.out.println("----------------------------" + Thread.currentThread().getName() + "    读到数据" + key + ":" + s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
