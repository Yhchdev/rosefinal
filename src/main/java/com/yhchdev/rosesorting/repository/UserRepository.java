package com.yhchdev.rosesorting.repository;

import com.yhchdev.rosesorting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String user_name);
}
