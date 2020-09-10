package com.example.kafkastream.service;

import com.example.kafkastream.other.EsChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shenliang
 * @since 2020-09-09
 */
@Component
public class EsKafkaMessageSender {

    @Resource
    private EsChannel channel;

    /**
     * 消息发送到默认通道：缺省通道对应缺省主题
     *
     * @param message
     */
    public void sendToDefaultChannel(String message) {
        System.out.println("发送:" + message);
        channel.sendEsDefaultMessage().send(MessageBuilder.withPayload(message).build());
    }

    /**
     * 消息发送到告警通道：告警通道对应告警主题
     *
     * @param message
     */
    public void sendToAlarmChannel(String message) {
        channel.sendEsAlarmMessage().send(MessageBuilder.withPayload(message).build());
    }
}
