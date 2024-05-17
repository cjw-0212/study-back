package com.example.springbootrocketmq.common;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author CJW
 * @since 2023/10/10
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        //指定第一条消息开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("studyTopic", "*");
        //指定采用广播模式消费，默认是集群模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        //注册监听器,broke有其订阅的信息就触发这个方法
        //其返回值为consumer的消费状态
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                            ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //消费消息的逻辑
                for (MessageExt messageExt : list) {
                    System.out.println(messageExt);
                }
                //返回消费状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Start");
    }
}
