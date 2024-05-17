package com.example.springbootrocketmq.delay;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CJW
 * @since 2023/10/10
 */
public class DelayProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hello," + i).getBytes();
            Message message = new Message("studyTopicB", "studyTag", body);
            //设置延迟消息的等级
            message.setDelayTimeLevel(3);
            SendResult sendResult = producer.send(message);
            System.out.print(new SimpleDateFormat("mm:ss").format(new Date()));
            System.out.println("," + sendResult);
        }
        producer.shutdown();
    }
}
