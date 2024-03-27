package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "returns")
public class Returns {

//	spring boot 中掃描 Spring Bean 和 Hibernate Entity
//	的起始點為:啟動程式的那個 package，
//	所以其他程式必須在該 package 底下

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer return_id;

    private Integer order_id;

    private String return_status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss EE") // 在 Java 環境內的時間格式(輸入時調整)
    private Date return_date;

    @PrePersist // 在物件轉換到 Persistent 狀態以前，做這個 function
    public void onCreate() {
        if (return_date == null) {
            return_date = new Date();
        }
    }


    @OneToMany(mappedBy = "returns", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReturnDetails> returnDetails;
}
