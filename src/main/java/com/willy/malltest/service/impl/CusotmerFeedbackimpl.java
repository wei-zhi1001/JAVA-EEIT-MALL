package com.willy.malltest.service.impl;

import com.willy.malltest.dto.CustomerFeedbackDTO;
import com.willy.malltest.dto.ShowCustomerFeedbackDTO;
import com.willy.malltest.model.*;
import com.willy.malltest.repository.CustomerFeedbackRepository;
import com.willy.malltest.repository.OrdersDetailRepository;
import com.willy.malltest.repository.OrdersRepository;
import com.willy.malltest.repository.UsersRepository;
import com.willy.malltest.service.CusotmerFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CusotmerFeedbackimpl implements CusotmerFeedback {

    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
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

    @Override
    public List<CustomerFeedbackDTO> getShowFeedbacksDTO(Long userId) {
        List<CustomerFeedback> customerFeedbacks = customerFeedbackRepository.findCustomerFeedbackByduserId(userId);
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

    @Override
    public List<ShowCustomerFeedbackDTO> getShowAllFeedbacksDTO(Long userId) {

        List<CustomerFeedback> customerFeedbacks = customerFeedbackRepository.findCustomerFeedbackByduserId(userId);


        List<ShowCustomerFeedbackDTO> showCustomerFeedbacksDTOs = new ArrayList<>();
        for (CustomerFeedback customerFeedback : customerFeedbacks) {
            ShowCustomerFeedbackDTO showCustomerFeedbacksDTO = new ShowCustomerFeedbackDTO();


            showCustomerFeedbacksDTO.setFeedbackID(customerFeedback.getFeedbackID());
            showCustomerFeedbacksDTO.setUserID(customerFeedback.getUser().getUserID());
            showCustomerFeedbacksDTO.setOrderID(customerFeedback.getOrders().getOrderID());
            showCustomerFeedbacksDTO.setType(customerFeedback.getType());
            showCustomerFeedbacksDTO.setFeedbackDate(customerFeedback.getFeedbackDate());
            showCustomerFeedbacksDTO.setDescription(customerFeedback.getDescription());
            showCustomerFeedbacksDTO.setCustomerFeedbackStatus(customerFeedback.getCustomerFeedbackStatus());
            showCustomerFeedbacksDTO.setProductName(customerFeedback.getOrders().getOrdersDetails().getProductSpec().getProduct().getProductName());
            showCustomerFeedbacksDTO.setPrice(customerFeedback.getOrders().getOrdersDetails().getProductSpec().getProduct().getPrice());

            showCustomerFeedbacksDTOs.add(showCustomerFeedbacksDTO);
        }
        return null;
    }


    @Transactional
    public CustomerFeedback addFeedbacksDTO(CustomerFeedbackDTO customerFeedbackDTO) {

        CustomerFeedback customerFeedback = new CustomerFeedback();

        User user = usersRepository.findById(customerFeedbackDTO.getUserID()).orElse(null);
        if (user != null) {
            customerFeedback.setUser(user);
        } else {
            // 如果找不到對應的 User，您可能希望進行錯誤處理或者返回 null 或者拋出異常
            // 此處僅示例，您可以根據您的需求進行處理
            System.out.println("找不到對應的使用者");
            return null;
        }

        Orders orders = ordersRepository.findById(customerFeedbackDTO.getOrderID()).get();
        if (orders != null) {
            customerFeedback.setOrders(orders);
        } else {
            // 如果找不到對應的 ProductSpec，您可能希望進行錯誤處理或者返回 null 或者拋出異常
            // 此處僅示例，您可以根據您的需求進行處理
            System.out.println("找不到對應的產品規格");
            return null;
        }

        CustomerFeedback existingcustomerFeedback = customerFeedbackRepository.findCustomerFeedbackByByordersIdAnduserId(customerFeedbackDTO.getOrderID(), customerFeedbackDTO.getUserID());
        if (existingcustomerFeedback != null) {
            // 如果已經存在相同的 Track，您可以根據需要執行相應的處理，例如返回 null 或拋出異常
            System.out.println("相同的 Track 已存在");
            return null;
        }
        customerFeedback.setType(customerFeedbackDTO.getType());
        customerFeedback.setDescription(customerFeedbackDTO.getDescription());
        customerFeedback.setCustomerFeedbackStatus(customerFeedbackDTO.getCustomerFeedbackStatus());

        return customerFeedbackRepository.save(customerFeedback); // 保存到資料庫中

    }


    @Transactional
    public CustomerFeedback updateFeedbacksDTO(CustomerFeedbackDTO customerFeedbackDTO){
        CustomerFeedback customerFeedback = new CustomerFeedback();

        CustomerFeedback existingcustomerFeedback = customerFeedbackRepository.findCustomerFeedbackByByordersIdAnduserId(customerFeedbackDTO.getOrderID(),customerFeedbackDTO.getUserID());
        if (existingcustomerFeedback == null) {
            // 如果已經存在相同的 Track，您可以根據需要執行相應的處理，例如返回 null 或拋出異常
            System.out.println("相同的 Track 已存在");
            return null;
        }

        User user = usersRepository.findById(customerFeedbackDTO.getUserID()).orElse(null);
        if (user != null) {
            existingcustomerFeedback.setUser(user);
        } else {
            // 如果找不到對應的 User，您可能希望進行錯誤處理或者返回 null 或者拋出異常
            // 此處僅示例，您可以根據您的需求進行處理
            System.out.println("找不到對應的使用者");
            return null;
        }

        Orders orders = ordersRepository.findById(customerFeedbackDTO.getOrderID()).get();
        if (orders != null) {
            existingcustomerFeedback.setOrders(orders);
        } else {
            // 如果找不到對應的 ProductSpec，您可能希望進行錯誤處理或者返回 null 或者拋出異常
            // 此處僅示例，您可以根據您的需求進行處理
            System.out.println("找不到對應的產品規格");
            return null;
        }

        existingcustomerFeedback.setType(customerFeedbackDTO.getType());
        existingcustomerFeedback.setDescription(customerFeedbackDTO.getDescription());
        existingcustomerFeedback.setCustomerFeedbackStatus(customerFeedbackDTO.getCustomerFeedbackStatus());

        return customerFeedbackRepository.save(existingcustomerFeedback); // 保存到資料庫中

    }

    @Override
    public void deleteCusotmerFeedback(CustomerFeedbackDTO customerFeedbackDTO) {

        CustomerFeedback customerFeedback = new CustomerFeedback();

        // 根據 userId 查找相應的 User 實體並設置給新 Track 對象
        User user = usersRepository.findById(customerFeedbackDTO.getUserID()).orElse(null);
        if (user != null) {
            customerFeedback.setUser(user);
        } else {
            // 如果找不到對應的 User，您可能希望進行錯誤處理或者返回 null 或者拋出異常
            // 此處僅示例，您可以根據您的需求進行處理
            System.out.println("找不到對應的使用者");
            return;
        }

        Orders orders = ordersRepository.findById(customerFeedbackDTO.getOrderID()).get();
        if (orders != null) {
            customerFeedback.setOrders(orders);
        } else {
            // 如果找不到對應的 ProductSpec，您可能希望進行錯誤處理或者返回 null 或者拋出異常
            // 此處僅示例，您可以根據您的需求進行處理
            System.out.println("找不到對應的產品規格");
            return;
        }

        CustomerFeedback existingcustomerFeedback = customerFeedbackRepository.findCustomerFeedbackByByordersIdAnduserId(customerFeedbackDTO.getOrderID(),customerFeedbackDTO.getUserID());
        if (existingcustomerFeedback == null) {
            // 如果已經存在相同的 Track，您可以根據需要執行相應的處理，例如返回 null 或拋出異常
            System.out.println("相同的 Track 已存在");
            return;
        }

        customerFeedbackRepository.delete(existingcustomerFeedback);
    }
}