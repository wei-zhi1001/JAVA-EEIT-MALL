package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
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
    private Integer userID;  //foreign key,

    @Column(name = "OrderDate")
    private Date orderDate;
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Column(name = "DeliverDate")
    private Date deliverDate;
    @Column(name = "PickupDate")
    private Date pickupDate;
    @Column(name = "DeliverAddress")
    private String deliverAddress;
    @Column(name = "RecipientName")
    private String recipientName;
    @Column(name = "RecipientPhone")
    private String recipientPhone;
    @Column(name = "PaymentTime")
    private Date paymentTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL )
    private Set<OrdersDetail> ordersDetails = new HashSet<OrdersDetail>();

}
