package com.willy.malltest.service;

import com.willy.malltest.dto.CartDto;
import com.willy.malltest.model.CartItems;

import java.util.List;

public interface CartService {
    public List<CartDto> findCartByUserId(Long userId);
    public boolean deleteCartItem(Integer cartItemId);
    public CartItems addToCart(Long userId, String specId);
    public void updateCartItemQuantity(CartDto cartDto);
}
