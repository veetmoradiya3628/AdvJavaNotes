package com.rabbitmq_tutorial.simple_rabbitmq_tutorial.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String QUEUE_NAME;

    @Value("${rabbitmq.queue.json_queue_name}")
    private String JSON_QUEUE_NAME;

    @Value("${rabbitmq.queue.exchange_name}")
    private String TOPIC_EXCHANGE_NAME;

    @Value("${rabbitmq.queue.routing_key}")
    private String ROUTING_KEY;

    @Value("${rabbitmq.queue.routing_key_json}")
    private String ROUTING_KEY_JSON;

    // spring bean for rabbitmq queue
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue jsonQueue() {
        return new Queue(JSON_QUEUE_NAME);
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

    @Bean
    public Binding jsonBinding() {
        return BindingBuilder.bind(jsonQueue())
                .to(topicExchange())
                .with(ROUTING_KEY_JSON);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin
}
