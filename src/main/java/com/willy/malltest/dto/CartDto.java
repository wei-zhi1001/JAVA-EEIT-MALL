package com.willy.malltest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
    private Integer cartItemId;
    private Integer productSpecId;
    private Integer productPhotoId;
    private byte[] photoFile;
    private String productName;
    private Integer productPrice;
    private Integer quantity;

}
