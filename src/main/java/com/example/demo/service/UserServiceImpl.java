package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String addUser(User user){
        userRepository.save(user);
        return "User added";
    }
    public String deleteUser( String username){
        userRepository.deleteByUsername(username);
        return "User Deleted";
    }

    public User getUser( String age ){
        return userRepository.getByAge(Integer.parseInt(age));

    }
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }
}




/*
*
* package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private List<User> users =  new ArrayList<>(Arrays.asList( new User("Nassim", 12),
            new User("Massilia", 24),
            new User("Fatima", 766),
            new User("Izane", 35)));

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String addUser(User user){
        users.add(user);
        return "User added";
    }
    public String deleteUser( String username){
        users.stream().map(User::getUsername).forEach(users::remove);
        return "User Deleted";
    }

    public User getUser( String id ){
        return users.get(Integer.parseInt(id));
    }
    public List<User> getAllUsers(){
        return users;
    }
}

*
* */