package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "ProductSpec")
@JsonIgnoreProperties({"product"})  // 忽略代理對象中的 product 屬性
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID")
    private Product product;

    //test
    @OneToMany(mappedBy = "productSpec",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Track> track;

    //test
    @OneToMany(mappedBy = "productPhotoSpec",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProductPhoto> productPhoto;
}