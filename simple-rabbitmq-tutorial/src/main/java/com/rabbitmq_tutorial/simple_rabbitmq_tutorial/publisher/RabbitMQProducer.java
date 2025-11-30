package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.queue.exchange_name}")
    private String TOPIC_EXCHANGE_NAME;

    @Value("${rabbitmq.queue.routing_key}")
    private String ROUTING_KEY;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        log.info("sendMessage called with -> {}", message);
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, message);
    }
}
