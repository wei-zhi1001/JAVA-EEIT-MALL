package com.willy.malltest.service;

import com.willy.malltest.dto.TrackDTO;
import com.willy.malltest.model.Track;

import java.util.List;

public interface TrackService {

    public List<TrackDTO> getAllTrackDTOs();

    public Track addTrack(String specID, Long userId);
}
