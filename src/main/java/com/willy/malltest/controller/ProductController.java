package com.willy.malltest.controller;


import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Product;
import com.willy.malltest.service.CustomerFeedBackService;
import com.willy.malltest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }
}
