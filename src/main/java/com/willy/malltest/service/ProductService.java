package com.willy.malltest.service;

import com.willy.malltest.model.CustomerFeedback;
import com.willy.malltest.model.Product;
import com.willy.malltest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}