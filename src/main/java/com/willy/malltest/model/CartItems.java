package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CartItems")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartItemID")
    private Integer cartItemId;

//    @Column(name = "UserID", nullable = false)
//    private int userId;

    // 假设ProductSpec是一个实体，且SpecID是其主键
    @Column(name = "SpecID",insertable=false, updatable=false, nullable = false)
    private String specId;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "SpecID", referencedColumnName = "specID")
    private ProductSpec productSpec;
}
