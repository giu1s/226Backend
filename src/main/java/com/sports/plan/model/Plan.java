package com.sports.plan.model;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("plan")
public class Plan {

    @Id
    private UUID id;
    private String name;
    private ArrayList<Exercise> exercises;
    private String note;


    public Plan(){

    }

    public Plan(String name, ArrayList<Exercise> exercises, String note) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.exercises = exercises;
        this.note = note;
    }

    public UUID getId() {
        return id;
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