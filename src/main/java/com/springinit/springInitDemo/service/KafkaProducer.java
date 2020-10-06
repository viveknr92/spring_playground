package com.springinit.springInitDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class KafkaProducer {

    private static final String TOPIC = "users";

//    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.format("#### -> Producing message -> %s\n", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
