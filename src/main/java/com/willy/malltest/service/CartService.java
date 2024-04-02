package com.willy.malltest.service;

import com.willy.malltest.dto.CartDto;
import com.willy.malltest.model.CartItems;

import java.util.List;

public interface CartService {
    public List<CartDto> findCartByUserId(Long userId);
}
