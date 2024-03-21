package com.willy.malltest.service;


import com.willy.malltest.dto.CustomerFeedbackDTO;
import com.willy.malltest.dto.TrackDTO;
import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Track;
import com.willy.malltest.repository.CustomerFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerFeedBackService {


    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;


//    public List<CustomerFeedback> getAllFeedbacks() {
//        return customerFeedbackRepository.findAll();
//    }

    @Transactional(readOnly = true)
    public List<CustomerFeedbackDTO> getAllFeedbacksDTO() {
        List<CustomerFeedback> customerFeedbacks = customerFeedbackRepository.findAll();
        List<CustomerFeedbackDTO> customerFeedbacksDTO = new ArrayList<>(); // 初始化空的 TrackDTO 列表
        for (CustomerFeedback customerFeedback : customerFeedbacks) { // 使用 for-each 迴圈遍歷 List 中的每個 Track 對象
            CustomerFeedbackDTO dto = new CustomerFeedbackDTO();
            dto.setFeedbackID(customerFeedback.getFeedbackID());
            dto.setUserID(customerFeedback.getUser().getUserID());
            dto.setOrderID(customerFeedback.getOrders().getOrderID());
            dto.setType(customerFeedback.getType());
            dto.setFeedbackDate(customerFeedback.getFeedbackDate());
            dto.setDescription(customerFeedback.getDescription());
            dto.setCustomerFeedbackStatus(customerFeedback.getCustomerFeedbackStatus());
            customerFeedbacksDTO.add(dto); // 將轉換後的 TrackDTO 加入到列表中
        }
        return customerFeedbacksDTO;
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
