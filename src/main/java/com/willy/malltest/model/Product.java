package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false, unique = true)
    private String productID;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_name", nullable = false)
    private String productName;

    // @ManyToOne(fetch = FetchType.LAZY)   //延遲加載
    @Column(name = "category_id",insertable=false, updatable=false, nullable = false)
    private String categoryID;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "chip")
    private String chip;

    @Column(name = "wifi")
    private String wifi;

    @Column(name = "size")
    private String size;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "memory")
    private String memory;

    @Column(name = "product_disk")
    private String productDisk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "setup_date", nullable = false)
    private Date setupDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date", nullable = false)
    private Date modifyDate;

    @ManyToOne(fetch = FetchType.LAZY)   //延遲加載
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSpec> productSpecs;
}
