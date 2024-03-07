package com.willy.malltest.repository;

import com.example.model.ProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecRepository extends JpaRepository<ProductSpec, String> {
}
