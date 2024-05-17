package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author CJW
 * @since 2024/3/17
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步调用无返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " completableFuture");
        });
        completableFuture.get();
        //异步调用有返回值
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " completableFuture1");
            //int i=1/0;
            return 10086;
        });
        completableFuture1.whenComplete((t,u)->{
            //返回值
            System.out.println(t);
            //异常
            System.out.println(u);
        }).get();
    }
}
