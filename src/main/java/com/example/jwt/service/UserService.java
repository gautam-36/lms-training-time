package com.example.jwt.service;

import com.example.jwt.entity.User;
import com.example.jwt.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private  UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(UserService.class);

    public List<User> allUsers(){
     //    List<User>  users =  new ArrayList<>();
        System.out.println("entred into all users");
        return userRepository.findAll();

    }
    public User getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);

        User user = new User();
        if(optionalUser.isPresent()){
            user  = optionalUser.get();
        }
        return user;
    }



}
