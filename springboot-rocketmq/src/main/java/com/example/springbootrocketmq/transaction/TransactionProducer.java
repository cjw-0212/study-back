package com.example.springbootrocketmq.transaction;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.*;


/**
 * @author CJW
 * @since 2023/10/11
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException,
            InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer("tpg");
        producer.setNamesrvAddr("127.0.0.1:9876");
        /**
         * corePoolSize:核心线程数
         * maximumPoolSize:线程池中最多线程数
         * keepAliveTime:线程池中线程数量大于核心线程数量时，空闲线程的存活时间
         * unit:时间单位
         * workQueue:临时存放任务的队列，参数为队列长度
         * threadFactory:线程工厂
         */
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });
        //为生产者指定线程池
        producer.setExecutorService(executorService);
        //添加事务监听器
        producer.setTransactionListener(new MyTransactionListener());
        producer.start();
        String[] tags = {"TAGA", "TAGB", "TAGC"};
        for (int i = 0; i < 3; i++) {
            byte[] body = ("Hi" + i).getBytes();
            Message message = new Message("TransactionTopic", tags[i], body);
            TransactionSendResult transactionSendResult = producer.sendMessageInTransaction(message, null);
            System.out.println(transactionSendResult);
        }
    }
}
