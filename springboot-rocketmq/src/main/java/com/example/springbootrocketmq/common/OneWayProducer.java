package com.example.springbootrocketmq.common;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author CJW
 * @since 2023/10/10
 */
public class OneWayProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //参数为生产者组的组名
        DefaultMQProducer producer = new DefaultMQProducer("common_async_message_producer_group");
        //指定nameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hello," + i).getBytes();
            Message message = new Message("single", "studyTag", body);
            //指定key
            message.setKeys("keys" + i);
            producer.sendOneway(message);
        }
        //关闭生产者
        producer.shutdown();
    }
}
