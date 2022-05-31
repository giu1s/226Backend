package com.sports.plan.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    
    @Id
    private long id;
    private String firtname;
    private String lastname;
    private String birthdate;
    private double height;
    
    public User(){

    }

    public User(String firtname, String lastname, String birthdate, double height) {
        this.firtname = firtname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
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

