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

//    @Transactional
//    public Track addTrack(String specID, Long userId) {
//        System.out.println("56778");
//
//        // 創建新的 Track 對象
//        Track newTrack = new Track();
//        newTrack.setUserID(userId);
//        newTrack.setSpecID(specID);
//
//        // 根據 userId 查找相應的 User 實體並設置給新 Track 對象
//        User user = up.findById(userId).orElse(null);
//        if (user != null) {
//            newTrack.setUser(user);
//        } else {
//            // 如果找不到對應的 User，您可能希望進行錯誤處理或者返回 null 或者拋出異常
//            // 此處僅示例，您可以根據您的需求進行處理
//            System.out.println("找不到對應的使用者");
//            return null;
//        }
//
//        // 根據 specID 查找相應的 ProductSpec 實體並設置給新 Track 對象
//        ProductSpec productSpec = pr.findById(specID).orElse(null);
//        if (productSpec != null) {
//            newTrack.setProductSpec(productSpec);
//        } else {
//            // 如果找不到對應的 ProductSpec，您可能希望進行錯誤處理或者返回 null 或者拋出異常
//            // 此處僅示例，您可以根據您的需求進行處理
//            System.out.println("找不到對應的產品規格");
//            return null;
//        }
//
//        System.out.println("1233");
//        return trackRepository.save(newTrack); // 保存到資料庫中
//    }

