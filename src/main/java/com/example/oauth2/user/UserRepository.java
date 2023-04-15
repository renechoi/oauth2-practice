package com.example.oauth2.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oauth2.user.User;

public interface UserRepository extends JpaRepository<User,Long> {

	boolean existsByEmail(String email);


}
