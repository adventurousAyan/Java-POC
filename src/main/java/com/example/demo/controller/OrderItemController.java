package com.example.demo.controller;

import com.example.demo.entity.OrderItem;
import com.example.demo.response.CustomResponse;
import com.example.demo.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/**
 * Order Item Service Controller Class
 */
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @PostMapping(value = "/orderItem")
    public CustomResponse createOrderItem(@RequestBody OrderItem orderItem) {
       return orderItemService.createOrderItem(orderItem);
    }

    @PostMapping(value = "/orderItems")
    public CustomResponse createOrderItems(@RequestBody List<OrderItem> orderItems) {
        return orderItemService.createOrderItems(orderItems);
    }


    @GetMapping(value = "/orderItems/{orderId}")
    public CustomResponse getOrderItemsByOrderId(@PathVariable long id) {
        return orderItemService.getItemsByOrderId(id);
    }
}
