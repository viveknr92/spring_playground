package com.springinit.springInitDemo.controller;

import com.springinit.springInitDemo.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "kafka")
public class GreetingController {
    @Autowired
    private KafkaProducer kafkaProducer;

//    @Autowired
//    private KafkaTemplate<String, String> kafkaProducer;

    @GetMapping("greetings")
    public String greeting (Map<String, Object> model) {
        model.put("message", "Hello Bryan");
        return "greetings";
    }

    @PostMapping(value = "publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.kafkaProducer.sendMessage(message);
    }
}
