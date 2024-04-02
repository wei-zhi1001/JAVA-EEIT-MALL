package com.willy.malltest.controller;

import com.willy.malltest.dto.CartDto;
import com.willy.malltest.model.CartItems;
import com.willy.malltest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CartController{
    @Autowired
    CartService cartService;
    @GetMapping("/cart/{userId}")
    public List<CartDto> getCartByUserId(@PathVariable Long userId) {
        List<CartDto> cart = cartService.findCartByUserId(userId);

        return cart;
    }
}
