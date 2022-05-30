package com.sports.plan.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private UUID id;
    private String firtname;
    private String lastname;
    private String birthdate;
    private double height;
    
    public User(){

    }

    public User(String firtname, String lastname, String birthdate, double height) {
        this.id = UUID.randomUUID();
        this.firtname = firtname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.height = height;
    }

    public UUID getId() {
        return id;
    }


    public String getFirtname() {
        return firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
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

