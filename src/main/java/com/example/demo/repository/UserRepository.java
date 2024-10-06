package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    // Delete a user by username
    void deleteByUsername(String username);
    List<User> getUsersByAge(int age);
    // Find user by age
    User getByAge(int age);
}
