package com.example.demo.service;

import com.example.demo.entity.OrderItem;
import com.example.demo.response.CustomResponse;

import java.util.List;

public interface IOrderItemService {

    /**
     * Create an Order-Item
     * @param orderItem
     * @return
     */
    CustomResponse createOrderItem(OrderItem orderItem);

    /**
     * Create multiple order-items
     * @param orderItems
     * @return
     */
    CustomResponse createOrderItems(List<OrderItem> orderItems);

    /**
     * Get Items by Order-Id
     * @param id
     * @return
     */
    CustomResponse getItemsByOrderId(long id);
}
