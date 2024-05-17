package threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author CJW
 * @since 2024/3/17
 */
public class Demo1 {
    public static void main(String[] args) {
        //一池n线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //一池一线程
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //一池可扩容，遇强则强
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 20; i++) {
                executorService2.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"正在处理");
                });
            }
        }finally {
            executorService.shutdown();
            //关闭之后不会再接受新的任务，但会完成之前接到的任务
           /* executorService.execute(()->{
                System.out.println(1);
            });*/
            System.out.println(executorService.isShutdown());
        }
    }
}
