package com.sports.plan.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("plan")
public class Plan {

    @Id
    private long id;
    private String name;
    private ArrayList<Exercise> exercises;
    private String note;


    public Plan(){

    }

    public Plan(long id, String name, ArrayList<Exercise> exercises, String note) {
        this.id = id;
        this.name = name;
        this.exercises = exercises;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
