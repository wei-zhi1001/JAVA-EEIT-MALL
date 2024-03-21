package com.willy.malltest.repository;

import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query(value = "SELECT * FROM Track WHERE SpecID = :specId AND UserID = :userId", nativeQuery = true)
    Track findTrackByspecIdAnduserId(@Param("specId") String specId, @Param("userId") Long userId);



}
