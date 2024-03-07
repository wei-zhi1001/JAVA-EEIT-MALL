package com.willy.malltest.repository;


import com.willy.malltest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
