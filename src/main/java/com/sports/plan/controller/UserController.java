package com.sports.plan.controller;

import java.util.List;

import com.sports.plan.generator.SequenceGeneratorService;
import com.sports.plan.model.User;
import com.sports.plan.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    SequenceGeneratorService sequenceGenerator;

    /**
     * @return all user
     */
    @GetMapping("/allusers")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    /**
     * create user
     * @param newUser created user
     * @return 
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        newUser.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        User savedUser = userRepository.insert(newUser);
        if ( savedUser == null ){
            throw new RuntimeException("Coulnd't create user");
        }
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    /**
     * update user
     * @param newUser user with new values
     * @return  
     */
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User newUser){
       User updatedUser = userRepository.save(newUser);
       if ( updatedUser == null ){
        throw new RuntimeException("Coulnd't create user");
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * delete user
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") long id){
       userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
