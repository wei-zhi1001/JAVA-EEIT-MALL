package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "OrdersDetail")
public class OrdersDetail {

    @Id
    @Column(name = "OrdersDetailID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordersDetailID;  //PRIMARY KEY identity(1,1),

    @Column(name = "OrderID", insertable = false, updatable = false)
    private int orderID;  //foreign key

    @Column(name = "SpecID", insertable = false, updatable = false)
    private String specID;  //foreign key

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SpecID", referencedColumnName = "SpecID")
    private ProductSpec productSpec;

}
