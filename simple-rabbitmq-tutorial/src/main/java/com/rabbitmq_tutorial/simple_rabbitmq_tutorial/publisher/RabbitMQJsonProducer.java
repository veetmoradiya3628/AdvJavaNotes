package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.publisher;

import com.rabbitmq_tutorial.simple_rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    @Value("${rabbitmq.queue.exchange_name}")
    private String TOPIC_EXCHANGE_NAME;

    @Value("${rabbitmq.queue.routing_key_json}")
    private String ROUTING_KEY;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        log.info("sendJsonMessage called with -> {}", user.toString());
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, ROUTING_KEY, user);
    }
}
