package com.willy.malltest.repository;

import com.willy.malltest.model.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Integer> {
}
