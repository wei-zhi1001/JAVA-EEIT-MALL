package com.willy.malltest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrackID")
    private Integer  trackID;
//
//    @Column(name = "SpecID")
//    private String specID;

//    @Column(name = "UserID")
//    private Long userID;

    //test
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    //test
    @ManyToOne
    @JoinColumn(name = "specID")
    private ProductSpec productSpec;
}
