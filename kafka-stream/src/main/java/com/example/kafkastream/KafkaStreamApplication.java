package com.example.kafkastream;

import com.example.kafkastream.other.EsChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(EsChannel.class)
public class KafkaStreamApplication {

    public static void main(String[] args) {
        // 参考 https://www.cnblogs.com/youngdeng/p/12869052.html
        // 参考 https://www.jianshu.com/p/a94c67f02c16
        SpringApplication.run(KafkaStreamApplication.class, args);
    }

}
