package sync;

/**
 * @author CJW
 * @since 2024/3/7
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
    private int number=0;
    public synchronized void incr() throws InterruptedException {
        //使用循环，不管wait合适醒来都会重新进行判断
        while (number!=0){
            //进行等待
            //wait在哪里等待就在哪里起来继续运行，如果使用if只会判断一次，会出现虚假唤醒的情况
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" "+number);
        //通知其他等待线程
        this.notifyAll();
    }
    public synchronized void decr() throws InterruptedException {
        while (number!=1){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" "+number);
        this.notifyAll();
    }
}
