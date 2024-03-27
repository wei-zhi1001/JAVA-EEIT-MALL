package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders_detail")
public class OrdersDetail {

    @Id
    @Column(name = "orders_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersDetailID;  //PRIMARY KEY identity(1,1),

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderID;  //foreign key

    @Column(name = "spec_id", insertable = false, updatable = false)
    private String specID;  //foreign key

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Orders orders;

}
