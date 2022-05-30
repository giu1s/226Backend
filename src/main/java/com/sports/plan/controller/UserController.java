package com.sports.plan.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.sports.plan.model.User;
import com.sports.plan.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;


    @GetMapping("/allusers")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    // @PostMapping("/user")
    // public ResponseEntity<User> createUser(@RequestBody User newUser){
    //     userService.save(newUser);
    //     return new ResponseEntity<>(HttpStatus.OK);
        
    // }


}
