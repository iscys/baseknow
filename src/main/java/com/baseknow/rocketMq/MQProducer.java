package com.baseknow.rocketMq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class MQProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer=new DefaultMQProducer("mygroup");
        producer.setNamesrvAddr("localhost:9876");
        producer.setVipChannelEnabled(false);
        producer.start();
        producer.send(new Message("TestTopic","123123".getBytes()),new SendCallback(){

            @Override
            public void onSuccess(SendResult sendResult) {
                    System.out.println("success");
            }

            @Override
            public void onException(Throwable e) {

            }
        });
    }
}
