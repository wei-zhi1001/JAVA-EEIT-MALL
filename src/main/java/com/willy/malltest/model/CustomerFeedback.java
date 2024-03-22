package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CustomerFeedback")

public class CustomerFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FeedbackID")
    private Integer feedbackID;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

//    @Column(name = "FeedbackDate")
//    private Date feedbackDate;

    @Column(name = "CustomerFeedbackStatus")
    private String customerFeedbackStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss EE") // 在 Java 環境內的時間格式(輸入時調整)
    @Column(name = "FeedbackDate")
    private Date feedbackDate;

    @PrePersist // 在物件轉換到 Persistent 狀態以前，做這個 function
    public void onCreate() {
        if (feedbackDate == null) {
            feedbackDate = new Date();
        }
    }

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Orders orders;
}