package com.willy.malltest.repository;

import com.willy.malltest.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
}
