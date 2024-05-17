package com.example.springbootrocketmq.common;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author CJW
 * @since 2023/10/10
 */
public class SyncMessageProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException,
            InterruptedException {
        //参数为生产者组的组名
        DefaultMQProducer producer = new DefaultMQProducer("common_sync_message_producer_group");
        //指定nameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //设置发送失败重试次数,默认为2次
        producer.setRetryTimesWhenSendFailed(3);
        //设置发送超时间,默认为3s
        producer.setSendMsgTimeout(5000);
        //开启生产者
        producer.start();
        //生产并发送一百条消息
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hello," + i).getBytes();
            Message message = new Message("studyTopic", "studyTag", body);
            //指定key
            message.setKeys("keys" + i);
            SendResult sendResult = producer.send(message);
        }
        //关闭生产者
        producer.shutdown();
    }
}
