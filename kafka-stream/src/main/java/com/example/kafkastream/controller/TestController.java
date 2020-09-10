package com.example.kafkastream.controller;

import com.example.kafkastream.service.EsKafkaMessageSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shenliang
 * @since 2020-09-09
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private EsKafkaMessageSender sender;

    @PostMapping(value = "/test1", produces = "application/json;charset=UTF-8")
    public void test1(String message, HttpServletRequest request,
                      HttpServletResponse response) {
        sender.sendToDefaultChannel(message);
    }

    @PostMapping(value = "/test2", produces = "application/json;charset=UTF-8")
    public void test2(String message, HttpServletRequest request,
                      HttpServletResponse response) {
        sender.sendToAlarmChannel(message);
    }
}
