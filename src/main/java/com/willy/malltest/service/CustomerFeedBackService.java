package com.willy.malltest.service;


import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.repository.CustomerFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerFeedBackService {


    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;


    public List<CustomerFeedback> getAllFeedbacks() {
        return customerFeedbackRepository.findAll();
    }
//
//    public Optional<CustomerFeedback> getFeedbackById(Integer id) {
//        return customerFeedbackRepository.findById(id);
//    }
//
//    public CustomerFeedback saveFeedback(CustomerFeedback feedback) {
//        return customerFeedbackRepository.save(feedback);
//    }
//
//    public void deleteFeedbackById(Integer id) {
//        customerFeedbackRepository.deleteById(id);
//    }
}
