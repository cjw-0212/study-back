package com.example.springbootrocketmq.batch;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2023/10/11
 */
public class BatchProducer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("127.0.0.1:9876");
        //指定发送消息的最大大小
        producer.setMaxMessageSize(4 * 1024 * 1024);
        producer.start();
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hello," + i).getBytes();
            Message message = new Message("batchTopic", "BatchTag", body);
            messages.add(message);
        }
        //将消息列表分割成多个不超过4M大小的小列表
        MessageListSplitter splitter = new MessageListSplitter(messages);
        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                producer.send(listItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }
}
