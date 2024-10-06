package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
public interface UserService {
    List<User> getAllUsers();
    User getUser(String id);
    String addUser(User user);
    String deleteUser(String username);

    List<User> getUsersByAge(int age);
}