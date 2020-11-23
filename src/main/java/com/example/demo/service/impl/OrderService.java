package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.repository.OrderRepository;
import com.example.demo.response.CustomResponse;
import com.example.demo.service.IOrderItemService;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * <p>Order Service for creating/retrieving orders</p>
 */
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IOrderItemService orderItemService;

    /**
     * Create Order
     * @param orderInfo
     * @return
     */
    public CustomResponse createOrder(Order orderInfo) {
        try {
            orderRepository.save(orderInfo);
            return new CustomResponse(HttpStatus.CREATED, "Order created successfully");
        }
        catch (Exception ex) {
            return new CustomResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create order for customer - "
                    + orderInfo.getCustomerName());
        }
    }

    /**
     * Retrieves all orders
     * @return
     */
    public CustomResponse getAllOrders(){
       List<Order> orderList = orderRepository.findAll();
       return new CustomResponse<>(HttpStatus.OK, orderList);
    }

    /**
     * Get order details by order-id
     * @param id
     * @return
     */
    public CustomResponse getOrderByOrderId(long id) {
        double totalCost;
        Order order = orderRepository.findOderInfoById(id);
        if(order == null) {
            throw new OrderNotFoundException("Order details not found for order id - " + id);
        }
        List<OrderItem> orderItems = (List<OrderItem>)orderItemService.getItemsByOrderId(id).getData();
        totalCost = orderItems.stream().mapToDouble(x -> x.getQuantity() * x.getPerItemCost()).sum();
        order.setTotal(totalCost);
        return new CustomResponse<>(HttpStatus.OK, order);
    }
}
