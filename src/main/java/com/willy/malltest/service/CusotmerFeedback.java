package com.willy.malltest.service;

import com.willy.malltest.dto.CustomerFeedbackDTO;
import com.willy.malltest.model.CustomerFeedback;

import java.util.List;

public interface CusotmerFeedback {

    public List<CustomerFeedbackDTO> getAllFeedbacksDTO();

    public CustomerFeedback addFeedbacksDTO(CustomerFeedbackDTO customerFeedbackDTO);
}
