package com.willy.malltest.repository;

import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer> {

    @Query(value = "SELECT * FROM CustomerFeedback WHERE OrderID = :orderID AND UserID = :userId", nativeQuery = true)
    CustomerFeedback findCustomerFeedbackByByordersIdAnduserId(@Param("orderID") Integer orderID, @Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE CustomerFeedback SET Type = :type, Description = :description, CustomerFeedbackStatus = :customerFeedbackStatus WHERE FeedbackID = :feedbackID", nativeQuery = true)
    void updateCustomerFeedback(@Param("type") String type, @Param("description") String description, @Param("customerFeedbackStatus") String customerFeedbackStatus, @Param("feedbackID") Integer feedbackID);
}
