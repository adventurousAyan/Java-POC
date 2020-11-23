package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name= "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="PRODUCT_CODE")
    private String productCode;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="QUANTITY")
    private int quantity;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="ORDER_ID")
    //@JsonBackReference("orderItemReference")
    @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "COST")
    private double perItemCost;
}
