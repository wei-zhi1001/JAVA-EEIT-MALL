package com.willy.malltest.controller;


import com.willy.malltest.dto.CustomerFeedbackDTO;
import com.willy.malltest.dto.TrackDTO;
import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Track;
import com.willy.malltest.service.CusotmerFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerFeedBackController {

    @Autowired
    private CusotmerFeedback cusotmerFeedback;

    @GetMapping("/feedbacks")
    public List<CustomerFeedbackDTO> getAllFeedbacks(){
        return cusotmerFeedback.getAllFeedbacksDTO();
    }

    @PostMapping("/create/customerdeedback")
    public CustomerFeedback createCustomerFeedbacks(@RequestBody CustomerFeedbackDTO customerFeedbackDTO){
        return cusotmerFeedback.addFeedbacksDTO(customerFeedbackDTO);
    }

    @DeleteMapping("/delete/customerdeedback")
    public void deleteCustomerFeedbacks(@RequestBody CustomerFeedbackDTO customerFeedbackDTO){
        cusotmerFeedback.deleteCusotmerFeedback(customerFeedbackDTO);
    }

}
