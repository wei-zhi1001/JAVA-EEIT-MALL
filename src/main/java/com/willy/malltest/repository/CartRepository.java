package com.willy.malltest.repository;

import com.willy.malltest.model.CartItems;
import com.willy.malltest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItems,Long> {
    public List<CartItems> findCartByUser(User userId);
}
