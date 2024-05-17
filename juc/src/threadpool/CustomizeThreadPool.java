package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author CJW
 * @since 2024/3/17
 */
public class CustomizeThreadPool {
    public static void main(String[] args) {
        /*  int corePoolSize 常驻线程数量
            int maximumPoolSize 最大线程数量
           long keepAliveTime 存活时间
           TimeUnit unit 时间单位
           BlockingQueue<Runnable> workQueue 阻塞队列
           ThreadFactory threadFactory 线程工程
           RejectedExecutionHandler handler 拒绝策略
        */
        /*
        执行execute（）方法后线程才被创建
        核心线程数用完了，就会进行阻塞队列
        阻塞队列满了就会创建新的线程
        最大线程数达到了就会使用拒绝策略
        * */
        ThreadPoolExecutor myThreadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 20; i++) {
                myThreadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"正在处理");
                });
            }
        }finally {
            myThreadPoolExecutor.shutdown();
            System.out.println(myThreadPoolExecutor.isShutdown());
        }
    }
}
