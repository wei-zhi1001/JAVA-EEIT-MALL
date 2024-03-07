package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "ProductSpec")
public class ProductSpec {

    @Id
    @Column(name = "SpecID", nullable = false, unique = true)
    private String specID;

    @Column(name = "ProductID", insertable = false, updatable = false, nullable = false)
    private String productId;

    @Column(name = "Color", nullable = false)
    private String color;

    @Column(name = "StockQuantity", nullable = false)
    private int stockQuantity;

    @Column(name = "PhotoFile1", nullable = false)
    private String photoFile1;

    @Column(name = "PhotoFile2")
    private String photoFile2;

    @Column(name = "PhotoFile3")
    private String photoFile3;

    @Column(name = "PhotoFile4")
    private String photoFile4;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID")
    private Product product;
}