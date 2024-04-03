package com.willy.malltest.service.impl;

import com.willy.malltest.dto.MemberShowOrdersDTO;
import com.willy.malltest.dto.OrderDetailDTO;
import com.willy.malltest.model.Orders;
import com.willy.malltest.model.OrdersDetail;
import com.willy.malltest.repository.OrdersRepository;
import com.willy.malltest.service.MemberOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberOrdersImpl implements MemberOrders {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<MemberShowOrdersDTO> getAllMemberOrders() {
        return null;
    }

    @Transactional
    public List<MemberShowOrdersDTO> getAllUserMemberOrders(Long userId) {
        List<Orders> orders = ordersRepository.findAll();
        List<MemberShowOrdersDTO> memberShowOrdersDTO = new ArrayList<>();
        for (Orders order : orders) { // 使用 for-each 迴圈遍歷 List 中的每個 Track 對象
            // 对于每个订单，可能需要聚合订单详情中的信息
            MemberShowOrdersDTO dto = new MemberShowOrdersDTO();

            dto.setOrderId(order.getOrderId());
            dto.setUser(order.getUser());
            dto.setOrderDate(order.getOrderDate());
            dto.setPaymentMethod(order.getPaymentMethod());

            dto.setOrderStatus(order.getOrderStatus());
            dto.setDeliverDate(order.getDeliverDate());
            dto.setPickupDate(order.getPickupDate());
            dto.setDeliverAddress(order.getDeliverAddress());
            dto.setRecipientName(order.getRecipientName());
            dto.setRecipientPhone(order.getRecipientPhone());
            dto.setPaymentTime(order.getPaymentTime());

            for (OrdersDetail detail : order.getOrdersDetails()) {
                OrderDetailDTO detailDTO = new OrderDetailDTO();
                detailDTO.setOrderPrice(detail.getPrice());
                detailDTO.setProductSpec(detail.getProductSpec().getSpecId());
                detailDTO.setProductName(detail.getProductSpec().getProduct().getProductName());
                detailDTO.setColor(detail.getProductSpec().getColor());
                detailDTO.setQuantity(detail.getQuantity());
                detailDTO.setPrice(detail.getProductSpec().getProduct().getPrice());
                dto.getOrderDetails().add(detailDTO);
            }
            memberShowOrdersDTO.add(dto);
        }
        return memberShowOrdersDTO;
    }
}
