package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.controller;

import com.rabbitmq_tutorial.simple_rabbitmq_tutorial.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    // /api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        this.rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to rabbitmq...");
    }
}
