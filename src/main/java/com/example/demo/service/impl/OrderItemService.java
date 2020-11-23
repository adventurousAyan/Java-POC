package com.example.demo.service.impl;

import com.example.demo.entity.OrderItem;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.response.CustomResponse;
import com.example.demo.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * <p>Order Item Service</p>
 */
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    /**
     * Create single order-item
     *
     * @param orderItem
     * @return
     */
    public CustomResponse createOrderItem(OrderItem orderItem) {
        try {
            orderItemRepository.save(orderItem);
            return new CustomResponse<>(HttpStatus.CREATED, "Order Item created successfully for order id - "
                    + orderItem.getOrderId());
        } catch (Exception ex) {
            return new CustomResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create order item for order id - "
                    + orderItem.getOrderId());
        }

    }

    /**
     * Create multiple order-items
     *
     * @param orderItems
     * @return
     */
    public CustomResponse createOrderItems(List<OrderItem> orderItems) {
        orderItemRepository.saveAll(orderItems);
        return new CustomResponse<>(HttpStatus.CREATED, "Order Items created successfully");
    }

    /**
     * Gets order-items by order-id
     *
     * @param id
     * @return
     */
    public CustomResponse getItemsByOrderId(long id) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(id);
        if (orderItems.size() > 0) {
            return new CustomResponse<>(HttpStatus.OK, orderItems);
        }
        throw new OrderNotFoundException("No Order Items found for given order id - " + id);
    }
}
