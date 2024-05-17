package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author CJW
 * @since 2024/3/15
 */
public class Demo1 {
    //实现Runnabe接口创建线程
    static class Thread1 implements Runnable {
        @Override
        public void run() {

        }
    }

    //实现callabe接口创建线程
    static class Thread2 implements Callable {
        //callable接口有返回值和异常抛出
        @Override
        public Object call() throws Exception {
            return 200;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new Thread1(), "A").start();
        FutureTask<Integer> futureTask1 = new FutureTask<>(new Thread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName()+"进行futureTask2");
            return 1024;
        });
        new Thread(futureTask2,"test2").start();
        new Thread(futureTask1,"test1").start();
//        while (!futureTask2.isDone()){
//            System.out.println(666);
//        }
        System.out.println(futureTask2.get());
        System.out.println(futureTask1.get());
    }
}























