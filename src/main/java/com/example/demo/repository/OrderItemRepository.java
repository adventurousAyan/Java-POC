package com.example.demo.repository;

import com.example.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * Find order by order-id
     * @param orderId
     * @return
     */
    List<OrderItem> findByOrderId(long orderId);
}
