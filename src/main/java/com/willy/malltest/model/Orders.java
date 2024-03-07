package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;  //PRIMARY KEY identity(1,1),

    @Column(name = "UserID", insertable = false, updatable = false)
    private int userID;  //foreign key,

    @Column(name = "OrderDate")
    private String orderDate;  //datetime可以轉String(?)
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Column(name = "DeliverDate")
    private String deliverDate;  //datetime可以轉String,
    @Column(name = "PickupDate")
    private String pickupDate;  //datetime可以轉String,
    @Column(name = "DeliverAddress")
    private String deliverAddress;
    @Column(name = "RecipientName")
    private String recipientName;
    @Column(name = "RecipientPhone")
    private String recipientPhone;
    @Column(name = "PaymentTime")
    private String paymentTime;  //datetime可以轉String,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Orders", cascade = CascadeType.ALL )
    private Set<OrdersDetail> ordersDetails = new HashSet<OrdersDetail>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Users users;

}
