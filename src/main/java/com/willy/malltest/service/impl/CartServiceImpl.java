package com.willy.malltest.service.impl;

import com.willy.malltest.dto.CartDto;
import com.willy.malltest.model.CartItems;
import com.willy.malltest.model.ProductPhoto;
import com.willy.malltest.model.ProductSpec;
import com.willy.malltest.model.User;
import com.willy.malltest.repository.CartRepository;
import com.willy.malltest.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    public List<CartDto> findCartByUserId(Long userId) {
        List<CartItems> cartItems = cartRepository.findCartByUser(new User(userId));
         List<CartDto> cartDtos = cartItems.stream().map(cartItem-> {
             CartDto cartDto = new CartDto();
             ProductSpec productSpec = cartItem.getProductSpec();
             BeanUtils.copyProperties(productSpec, cartDto);
             BeanUtils.copyProperties(cartItem, cartDto);

             List<ProductPhoto> productPhotos = cartItem.getProductSpec().getProductPhotos();
             if (productPhotos != null && productPhotos.size() != 0) {
                 ProductPhoto productPhoto = productPhotos.get(0);
                 cartDto.setProductPhotoId(productPhoto.getPhotoId());
                 cartDto.setPhotoFile(productPhoto.getPhotoFile());
             }
             return cartDto;
         }).toList();
         return cartDtos;

    }

}
