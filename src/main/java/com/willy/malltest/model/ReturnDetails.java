package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ReturnDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ReturnDetailID;



    private Integer OrdersDetailID;

    private String ReturnReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReturnID")
    private Returns returns;
}
