package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @OneToMany(mappedBy = "user")
    private Set<ThirdParty> thirdParty = new HashSet<>();

    @Column(name = "user_name")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss EE") // 在 Java 環境內的時間格式(輸入時調整)
    @Column(name = "register_date")
    private Date RegisterDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss EE") // 在 Java 環境內的時間格式(輸入時調整)
    @Column(name = "last_login_time")
    private Date LastLoginTime;

    @Column(name = "user_address")
    private String UserAddress;
    @Column(name = "deliver_address")
    private String DeliverAddress;
    @Column(name = "phone")
    private String Phone;
    @Column(name = "authentication")
    private Integer Authentication;

    @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Orders> orders = new HashSet<>();


    //test
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Track> track;

    //test
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CustomerFeedback> customerFeedback;

    public void add(Orders order) {

        if (order != null) {

            if (orders == null) {
                orders = new HashSet<>();
            }

            orders.add(order);
            order.setUserID(this);
        }
    }
}
