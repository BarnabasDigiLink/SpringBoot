package com.example.CRUDApp.dao;

import com.example.CRUDApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
