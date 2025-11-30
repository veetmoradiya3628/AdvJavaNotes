package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String QUEUE_NAME;

    @Value("${rabbitmq.queue.exchange_name}")
    private String TOPIC_EXCHANGE_NAME;

    @Value("${rabbitmq.queue.routing_key}")
    private String ROUTING_KEY;

    // spring bean for rabbitmq queue
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    // binding between queue and exchange using routing key
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(topicExchange())
                .with(ROUTING_KEY);
    }

    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin
}
