package com.willy.malltest.controller;


import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.service.CustomerFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerFeedBackController {

    @Autowired
    private CustomerFeedBackService customerFeedBackService;

    @GetMapping("/feedbacks")
    public List<CustomerFeedback> getAllFeedbacks(){
        return customerFeedBackService.getAllFeedbacks();
    }

}
