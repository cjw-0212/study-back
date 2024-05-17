package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author CJW
 * @since 2024/3/17
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask=new MyTask(1,100);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myTask);
        System.out.println(submit.get());
    }
}
class MyTask extends RecursiveTask<Integer> {
    private int left;
    private int right;
    private int result;
    public MyTask(int left,int right){
        this.left=left;
        this.right=right;
    }
    @Override
    protected Integer compute() {
        //相加区间差小于10进行累加
        if (right-left<=10){
            for (int i=left;i<=right;i++){
                result+=i;
            }
        }else {
            int middle=(left+right)/2;
            MyTask task1=new MyTask(left,middle);
            MyTask task2=new MyTask(middle+1,right);
            task1.fork();
            task2.fork();
            result=task1.join()+ task2.join();
        }
        return result;
    }
}
