package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.pojo.MessageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author shenliang
 * @since 2020-09-09
 */
@Log
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "${kafka.topic.order}", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload String message) {
        System.out.println("时间：" + System.currentTimeMillis());

        /*GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        Gson gson = builder.create();
        // 将接收到的消息反序列化消息实例
        MessageBean messageBean = gson.fromJson(message, MessageBean.class);
        // 将消息实例序列化为json格式的字符串
        String json = gson.toJson(messageBean);
        // 打印消息
        log.info("\nminiooc receive message：\n" + json);*/

        log.info("\nminiooc receive message：\n" + message);
    }
}
