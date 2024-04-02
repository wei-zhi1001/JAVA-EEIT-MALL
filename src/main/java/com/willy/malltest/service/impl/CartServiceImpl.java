package com.willy.malltest.service.impl;

import com.willy.malltest.dto.CartDto;
import com.willy.malltest.model.*;
import com.willy.malltest.repository.CartRepository;
import com.willy.malltest.repository.ProductPhotoRepository;
import com.willy.malltest.repository.ProductRepository;
import com.willy.malltest.repository.ProductSpecRepository;
import com.willy.malltest.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductSpecRepository productSpecRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    public List<CartDto> findCartByUserId(Long userId) {
        List<CartItems> cartItems = cartRepository.findCartByUser(new User(userId));

        List<CartDto> cartDtos = new ArrayList<>();
        for (CartItems cartItem : cartItems) {
            CartDto cartDto = new CartDto();

            // 获取商品规格信息
            ProductSpec productSpec = productSpecRepository.findProductSpecBySpecId(cartItem.getProductSpec().getSpecId());

            // 获取商品信息
            Product product = productRepository.findById(productSpec.getProduct().getProductId()).orElse(null);
            if (product != null) {
                // 设置商品名称和价格
                cartDto.setProductName(product.getProductName());
                cartDto.setProductPrice(product.getPrice());
            }

            // 设置购物车项其他信息
            cartDto.setCartItemId(cartItem.getCartItemId());
            cartDto.setSpecId(cartItem.getProductSpec().getSpecId());
            cartDto.setQuantity(cartItem.getQuantity());

             List<ProductPhoto> productPhotos= productPhotoRepository.findProductPhotoByProductSpec(productSpec);
             if (productPhotos != null && productPhotos.size() != 0) {
                 ProductPhoto productPhoto = productPhotos.get(0);
                 cartDto.setProductPhotoId(productPhoto.getPhotoId());
                 cartDto.setPhotoFile(productPhoto.getPhotoFile());
             }

//             List<ProductPhoto> productPhotos = cartItem.getProductSpec().getProductPhotos();
//             if (productPhotos != null && productPhotos.size() != 0) {
//                 ProductPhoto productPhoto = productPhotos.get(0);
//                 cartDto.setProductPhotoId(productPhoto.getPhotoId());
//                 cartDto.setPhotoFile(productPhoto.getPhotoFile());
//             }
            cartDtos.add(cartDto);
        }
        return cartDtos;
    }
}
