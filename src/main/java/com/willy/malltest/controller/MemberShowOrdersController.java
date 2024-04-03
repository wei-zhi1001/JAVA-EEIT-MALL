package com.willy.malltest.controller;

import com.willy.malltest.dto.MemberShowOrdersDTO;
import com.willy.malltest.dto.ShowCustomerFeedbackDTO;
import com.willy.malltest.service.MemberOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class MemberShowOrdersController {

    @Autowired
    private MemberOrders memberOrders;

    @GetMapping("/memberOrders/showAllOrders")
    public List<MemberShowOrdersDTO> getShowOrders(){
        return memberOrders.getAllMemberOrders();
    }

    @GetMapping("/memberOrders/showAllUserOrders")
    public List<MemberShowOrdersDTO> getShowAllFeedbacks(@RequestParam("userId") Long userId){
        return memberOrders.getAllUserMemberOrders(userId);
    }

}
