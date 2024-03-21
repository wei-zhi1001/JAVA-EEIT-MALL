package com.willy.malltest.repository;

import com.willy.malltest.model.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer> {


}
