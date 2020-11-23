package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.response.CustomResponse;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
/**
 * Order Service Controller Class
 */
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/order")
    public CustomResponse addOrder(@RequestBody Order order) {
       return orderService.createOrder(order);
    }

    @GetMapping(value = "/orders")
    public CustomResponse getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/orders/{id}")
    public CustomResponse getOrderByOrderId(@PathVariable int id) {
        return orderService.getOrderByOrderId(id);
    }
}
