package com.gt.SpringBootBasicTraining.rabbitmq;

import com.gt.SpringBootBasicTraining.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    @RabbitListener(queues = "${app.rabbitmq.gt.queue-name}")
    public void handleMessageFromQueue(Order order){
        System.out.println("Message received from queue: " + order);
    }
}
