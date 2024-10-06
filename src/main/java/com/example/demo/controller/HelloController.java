package com.example.demo.controller;

import com.example.demo.DemoConfiguration;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

    @Autowired
    private DemoConfiguration demoConfiguration;


    /**
     * Hello string.
     *
     * @return the string
     */
    @Value("${exemple.var1}")
    private String greetingMessage;

    @MyCustomAnnotation
    @GetMapping("/")
    public String hello() {
        final int dd =  demoConfiguration.getVar1();
        final String ddd =  demoConfiguration.getVar2();
        return "Hello World! "+ greetingMessage;
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


    /**
     * Search users by age list.
     *
     * @param age the age
     * @return the list of users
     */
    @GetMapping("/searchUsers")
    public List<User> searchUsersByAge(@RequestParam int age) {
        return userService.getUsersByAge(age);
    }
}
