package com.demo.SpringSecurityTest.Authentication.repositories;

import com.demo.SpringSecurityTest.Authentication.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
