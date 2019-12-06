package com.sxw.springbootproducer.controller;

import com.sxw.entity.Order;
import com.sxw.springbootproducer.service.OrderService;
import com.sxw.springbootproducer.util.IdWorker;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@Api(tags = "消息管理")
@RestController
public class MessageController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/send")
    public void sendOrderMessage() throws Exception {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setName("测试订单:"+UUID.randomUUID().toString());
        order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
        orderService.createOrder(order);
    }
}
