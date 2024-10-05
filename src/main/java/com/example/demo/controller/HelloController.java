package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Hello controller.
 */
@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    /**
     * Hello string.
     *
     * @return the string
     */
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Get user user.
     *
     * @param id the id
     * @return the user
     */
    @GetMapping("/getUsers/{id}")
    public User getUser(@PathVariable String id ){
        return userService.getUser(id);
    }

    /**
     * Add user string.
     *
     * @param user the user
     * @return the string
     */
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

    /**
     * Delete user string.
     *
     * @param username the username
     * @return the string
     */
    @DeleteMapping("/getUsers/{username}")
    @Transactional
    public String deleteUser(@PathVariable  String username){
        return userService.deleteUser(username);
    }
}
