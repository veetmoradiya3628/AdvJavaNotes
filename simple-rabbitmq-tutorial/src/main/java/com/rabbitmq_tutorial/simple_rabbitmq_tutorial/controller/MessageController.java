package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.controller;

import com.rabbitmq_tutorial.simple_rabbitmq_tutorial.dto.User;
import com.rabbitmq_tutorial.simple_rabbitmq_tutorial.publisher.RabbitMQJsonProducer;
import com.rabbitmq_tutorial.simple_rabbitmq_tutorial.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    // /api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        this.rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to rabbitmq...");
    }

    // /api/v1/publish-json
    @PostMapping("/publish-json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON message send successfully!");
    }
}
