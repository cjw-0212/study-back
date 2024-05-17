package com.example.springbootrocketmq.transaction;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author CJW
 * @since 2023/10/11
 */
public class TransactionConsumer {
    public static void main(String[] args) throws MQClientException, MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("tcg");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TransactionTopic", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            // 一旦broker中有了其订阅的消息就会触发该方法的执行，
            // 其返回值为当前consumer消费的状态
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                // 逐条消费消息
                for (MessageExt msg : msgs) {
                    System.out.println(msg);
                }
                // 返回消费状态：消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 开启消费者消费
        consumer.start();
        System.out.println("Consumer Started");
    }
}
