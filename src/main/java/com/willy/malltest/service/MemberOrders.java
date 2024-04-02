package com.willy.malltest.service;

import com.willy.malltest.dto.MemberShowOrdersDTO;

import java.util.List;

public interface MemberOrders {
    public List<MemberShowOrdersDTO> getAllMemberOrders();
}
