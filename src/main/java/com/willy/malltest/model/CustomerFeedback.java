package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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

    @Column(name = "FeedbackDate")
    private Date feedbackDate;

    @Column(name = "CustomerFeedbackStatus")
    private String customerFeedbackStatus;


    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderID")
    private Orders orders;
}