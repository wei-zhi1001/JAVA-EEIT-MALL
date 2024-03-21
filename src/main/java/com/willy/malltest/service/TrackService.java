package com.willy.malltest.service;

import com.willy.malltest.dto.TrackDTO;
import com.willy.malltest.model.ProductSpec;
import com.willy.malltest.model.Track;
import com.willy.malltest.model.User;
import com.willy.malltest.repository.ProductRepository;
import com.willy.malltest.repository.ProductSpecRepository;
import com.willy.malltest.repository.TrackRepository;
import com.willy.malltest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;
    @Autowired
    private UsersRepository up;
    @Autowired
    private ProductSpecRepository pr;
//    @Autowired
//    private TrackRepository UserRepository;
//
//    @Autowired
//    private TrackRepository ProductSpecRepository;

//    @Transactional(readOnly = true)
//    public List<Track> getAllTrack() {
//        return trackRepository.findAll();
//    }

    @Transactional(readOnly = true)
    public List<TrackDTO> getAllTrackDTOs() {
        List<Track> tracks = trackRepository.findAll();
        List<TrackDTO> tracksdto = new ArrayList<>(); // 初始化空的 TrackDTO 列表
        for (Track track : tracks) { // 使用 for-each 迴圈遍歷 List 中的每個 Track 對象
            TrackDTO dto = new TrackDTO();
            dto.setTrackID(track.getTrackID());
            dto.setUserID(track.getUser().getUserID());
            dto.setSpecID(track.getProductSpec().getSpecID());
            tracksdto.add(dto); // 將轉換後的 TrackDTO 加入到列表中
        }
        return tracksdto;
    }


    @Transactional
    public Track addTrack(String specID, Long userId){
//        if(trackRepository.findTrackByspecIdAnduserId(specID,userId) != null){
//            return null;
//        }
        // 例如，創建新的 Track 對象並保存到資料庫中，然後返回相應的 TrackDTO 對象
        System.out.println("56778");

        Track newTrack = new Track(); // 創建新的 Track 對象
//        newTrack.setUserID(userId);
//        newTrack.setSpecID(specID);
        Long uuddd=userId;
        System.out.println("1005678");

        System.out.println(up.findById(uuddd));
        newTrack.setUser(up.findById(uuddd).get());
        System.out.println(up.findById(uuddd).get());
        System.out.println("19611");

        newTrack.setProductSpec(pr.findById(specID).get());
        System.out.println("1233");
        return trackRepository.save(newTrack); // 保存到資料庫中

    }
    //商品名稱 價格 圖片
}
