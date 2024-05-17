package com.example.springbootrocketmq.common;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author CJW
 * @since 2023/10/10
 */
public class OrderProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Integer orderId = i;
            byte[] body = ("Hello," + i).getBytes();
            Message message = new Message("studyTopicA", "studyTag", body);
            //将orderId作为消息key一起传过去
            message.setKeys(orderId.toString());
            //send()的第三个参数orderId会传递给选择器的第三个参数o
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    String keys = message.getKeys();
                    Integer id = Integer.valueOf(keys);
                    int index = id % list.size();
                    return list.get(index);
                }
            }, orderId);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
