package com.baseknow.rocketMq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class MQClient {

    public static void main(String[] args)throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("mygroup");
        consumer.subscribe("TestTopic","*");
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setVipChannelEnabled(false);
        consumer.setNamesrvAddr("localhost:9876");

        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for(MessageExt ext:list){
                     String msg = new String(ext.getBody());
                     System.out.println(msg);

                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("hhhh");

    }
}
