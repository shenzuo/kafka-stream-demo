package com.example.kafkastream.service;

import com.example.kafkastream.other.EsChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shenliang
 * @since 2020-09-09
 */

@EnableBinding(value = EsChannel.class)
public class EsStreamListener {
    /**
     * 从缺省通道接收消息
     *
     * @param message
     */
    @StreamListener(EsChannel.ES_DEFAULT_INPUT)
    public void receive(Message<String> message) {
        System.out.println("时间：" + System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()) + "------start--------安全用电默认消息：" + message);
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(new Date()) + "------end--------安全用电默认消息");
    }

    /**
     * 从告警通道接收消息
     *
     * @param message
     */
    @StreamListener(EsChannel.ES_ALARM_INPUT)
    public void receiveAlarm(Message<String> message) {
        System.out.println("订阅告警消息：" + message);
    }
}
