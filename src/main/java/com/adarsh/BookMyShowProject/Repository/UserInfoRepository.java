package com.adarsh.BookMyShowProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarsh.BookMyShowProject.entity.User;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);

   
}
