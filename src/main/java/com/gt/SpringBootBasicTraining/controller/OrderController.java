package com.gt.SpringBootBasicTraining.controller;

import com.gt.SpringBootBasicTraining.model.Order;
import com.gt.SpringBootBasicTraining.model.OrderStatus;
import com.gt.SpringBootBasicTraining.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    public static final String IN_PROGRESS = "IN_PROGRESS";
    private final OrderService orderService;

    @PostMapping
    public OrderStatus createOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        orderService.createOrderAsync(order);
        OrderStatus orderStatus = new OrderStatus(order, IN_PROGRESS,"The order was successfully acquired and submitted for pre-processing");
        return orderStatus;
    }
}
