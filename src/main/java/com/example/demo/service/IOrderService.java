package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.response.CustomResponse;

public interface IOrderService {

    /**
     * Create an order
     * @param orderInfo
     * @return
     */
    CustomResponse createOrder(Order orderInfo);

    /**
     * Gets an order by order-id
     * @param id
     * @return
     */
    CustomResponse getOrderByOrderId(long id);

    /**
     * Retrieves all orders
     * @return
     */
    CustomResponse getAllOrders();
}
