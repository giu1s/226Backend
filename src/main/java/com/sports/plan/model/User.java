package com.sports.plan.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sports.plan.generator.SequenceGeneratorService;

@Document(collection = "user")
public class User {
    
    
    
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    
    @Id
    private long id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private double height;
    
    public User(){

    }

    public User(String firstname, String lastname, String birthdate, double height) {
        this.setId();
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(){
        this.id = SequenceGeneratorService.generateSequence(User.SEQUENCE_NAME);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    
}

