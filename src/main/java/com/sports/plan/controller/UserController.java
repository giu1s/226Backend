package com.sports.plan.controller;

import java.time.LocalDate;
import java.util.Date;

import com.sports.plan.model.User;
import com.sports.plan.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;


    @GetMapping("/allusers")
    public User getUser(){
        User user = new User("Giuia", "Ferraina", "23.06.2004", 176.0);
        this.userRepository.save(user);
        User userRepo = userRepository.findAll().get(0);
        return userRepo;
    }


}
