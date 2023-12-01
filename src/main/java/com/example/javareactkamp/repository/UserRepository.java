package com.example.javareactkamp.repository;

import com.example.javareactkamp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
