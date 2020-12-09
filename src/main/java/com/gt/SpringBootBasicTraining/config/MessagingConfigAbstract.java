package com.gt.SpringBootBasicTraining.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class MessagingConfigAbstract {

    @Value("${app.rabbitmq.gt.queue-name}")
    private String SP_GT_QUEUE;

    @Value("${app.rabbitmq.gt.exchange-name}")
    private String SP_GT_TOPIC_EXCHANGE = "sp_gt_topic_exchange";

    @Value("${app.rabbitmq.gt.routing-key-name}")
    private String SP_GT_ROUTING_KEY = "sp_gt_routing_key";
}