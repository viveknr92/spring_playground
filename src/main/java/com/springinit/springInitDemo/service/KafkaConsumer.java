package com.springinit.springInitDemo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        System.out.format("#### -> Consumed message -> %s", message);
    }
}
