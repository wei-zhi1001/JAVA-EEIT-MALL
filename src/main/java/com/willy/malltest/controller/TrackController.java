package com.willy.malltest.controller;

import com.willy.malltest.dto.TrackDTO;
import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Track;
import com.willy.malltest.service.TrackService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/track")
    public List<TrackDTO> getAllTrack(){
        return trackService.getAllTrackDTOs();
    }
    @PostMapping("/creat/track")
    public Track creatTrack(@RequestBody Track track){
        System.out.println("Dadsadasd");
        Long userId = track.getUserID();
        String specID = track.getSpecID();
        System.out.println(userId);
        System.out.println(specID);
        return trackService.addTrack(specID,userId);

    }
}
