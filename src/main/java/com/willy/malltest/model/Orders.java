package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;  //PRIMARY KEY identity(1,1),

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User userID;  //foreign key,

    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "deliver_date")
    private Date deliverDate;
    @Column(name = "pickup_date")
    private Date pickupDate;
    @Column(name = "deliver_address")
    private String deliverAddress;
    @Column(name = "recipient_name")
    private String recipientName;
    @Column(name = "recipient_phone")
    private String recipientPhone;
    @Column(name = "payment_time")
    private Date paymentTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL )
    private List<OrdersDetail> ordersDetails = new ArrayList<>();

    //test
    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<CustomerFeedback> customerFeedback;

}
