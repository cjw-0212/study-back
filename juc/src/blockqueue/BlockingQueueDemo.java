package blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author CJW
 * @since 2024/3/17
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        /**
         * 第一组方法
         * add（）添加元素超出容量抛出异常
         * element（）返回队头但不取出，没有元素抛出异常
         * remove（）取元素，没有抛出异常
         */

        /**
         * 第二组方方法
         * offer（）放入数据成功返回true，超过容量异常返回false
         * poll（）取出数据，有的话返回取出值，没有返回null
         */

        /**
         * 第三组方法
         * put（）超过容量会一直阻塞直到有空间放入
         * take（）取出数据，如果队列为空会阻塞知道有元素可以取出
         */

        /**
         * 第四组操作
         */
        blockingQueue.offer(1);
        blockingQueue.offer(2);
        blockingQueue.offer(3);
        //阻塞超过三秒就会自动结束
        //blockingQueue.offer(4,3, TimeUnit.SECONDS);

        //取出阻塞超过时间自动结束
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
    }
}
