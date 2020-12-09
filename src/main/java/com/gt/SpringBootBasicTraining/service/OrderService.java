package com.gt.SpringBootBasicTraining.service;

import com.gt.SpringBootBasicTraining.config.MessagingConfigAbstract;
import com.gt.SpringBootBasicTraining.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate template;
    private final MessagingConfigAbstract messagingConfigAbstract;

    public void createOrderAsync(Order order){
        System.out.println("Publishing message");
        template.convertAndSend(messagingConfigAbstract.getSP_GT_TOPIC_EXCHANGE(), messagingConfigAbstract.getSP_GT_ROUTING_KEY(),order);
    };
}
