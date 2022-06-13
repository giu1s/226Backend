package com.sports.plan.model;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sports.plan.generator.SequenceGeneratorService;

@Document("plan")
public class Plan {

    @Autowired
    SequenceGeneratorService sequenceGenerator;
    
    @Transient
    public static final String SEQUENCE_NAME = "plans_sequence";
    
    @Id
    private long id;
    private String name;
    private ArrayList<Exercise> exercises;
    private String note;


    public Plan(){

    }

    public Plan(String name, ArrayList<Exercise> exercises, String note) {
        this.setId();
        this.name = name;
        this.exercises = exercises;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(){
        this.id = sequenceGenerator.generateSequence(SEQUENCE_NAME);
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
