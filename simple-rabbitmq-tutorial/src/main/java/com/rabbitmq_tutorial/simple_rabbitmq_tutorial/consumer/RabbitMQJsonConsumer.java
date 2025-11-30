package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.consumer;

import com.rabbitmq_tutorial.simple_rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json_queue_name}"})
    public void consume(User user){
        log.info("Received user message -> {}", user.toString());
    }
}
