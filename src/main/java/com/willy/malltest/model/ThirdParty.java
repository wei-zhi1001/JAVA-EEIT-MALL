package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "thirdparty")
public class ThirdParty {
    @Id
    @Column(name = "ProviderID1")
    private String ProviderID1;
    @Column(name = "ProviderName")
    private String ProviderName;
    @Column(name = "UserID")
    private Long UserID;


    @ManyToOne // 指定多对一关系
    @JoinColumn(name = "UserID") // 指定关联的外键列
    private User user; // 指向 User 类的引用




}
