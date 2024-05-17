package com.example.springbootrocketmq.common;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

/**
 * @author CJW
 * @since 2023/10/10
 */
public class AsyncMessageProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException,
            InterruptedException {
        //参数为生产者组的组名
        DefaultMQProducer producer = new DefaultMQProducer("common_async_message_producer_group");
        //指定nameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //指定异步发送失败不重试
        producer.setRetryTimesWhenSendAsyncFailed(0);
        //指定queue的数量，默认是4
        producer.setDefaultTopicQueueNums(2);
        //开启生产者
        producer.start();
        //生产并发送一百条消息
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hello," + i).getBytes();
            Message message = new Message("studyTopicA", "studyTag", body);
            //异步发送，指定回调
            producer.send(message, new SendCallback() {
                //当producer接收到MQ发送的ACK后就会触发回调
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                //发生异常
                @Override
                public void onException(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
        //休眠一下,不能立即关闭因为是异步发送的要等待发送
        //如果不sleep就会报错
        TimeUnit.SECONDS.sleep(3);
        //关闭生产者
        producer.shutdown();
    }
}
