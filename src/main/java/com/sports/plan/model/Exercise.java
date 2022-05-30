package com.sports.plan.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("exercise")
public class Exercise {
    @Id
    private long id;
    private String firtname;
    private String lastname;
    private Date birthdate;
    private double height;
    
    public Exercise(){

    }

    public Exercise(long id, String firtname, String lastname, Date birthdate, double height) {
        this.id = id;
        this.firtname = firtname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    
}
