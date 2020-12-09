package com.gt.SpringBootBasicTraining.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessagingConfig {
    private final MessagingConfigAbstract messagingConfigAbstract;

    @Bean
    public Queue queue(){
        return new Queue(messagingConfigAbstract.getSP_GT_QUEUE());
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(messagingConfigAbstract.getSP_GT_TOPIC_EXCHANGE());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
       return BindingBuilder.bind(queue).to(topicExchange).with(messagingConfigAbstract.getSP_GT_ROUTING_KEY());
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
