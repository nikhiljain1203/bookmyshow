package com.example.bookmyshow.repositories;


import com.example.bookmyshow.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    @Override
    Optional<User> findById(Long aLong);
}
