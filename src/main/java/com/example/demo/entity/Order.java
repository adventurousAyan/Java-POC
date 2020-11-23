package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name= "ORDER_INFO")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="CUSTOMER_NAME")
    private String customerName;
    @Column(name="ORDER_DATE")
    private String orderDate;
    @Column(name="SHIPPING_ADDRESS")
    private String shippingAddress;
    //@OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
    //@JsonManagedReference("orderItemReference")
    @Transient
    private Set<OrderItem> orderItems;
    @Column(name="TOTAL_COST")
    private double total;
}
