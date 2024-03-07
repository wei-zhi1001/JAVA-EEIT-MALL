package com.willy.malltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

@Getter
@Setter
@Entity
@Table(name = "Track")
public class Track {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "TrackID")
//    private int  trackID;
//
//    @Column(name = "SpecID")
//    private String specID;


//    @ManyToOne
//    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
//    private Users users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrackID")
    private int  trackID;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "SpecID", referencedColumnName = "SpecID")
    private ProductSpec productSpec;
}
