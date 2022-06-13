package com.sports.plan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("exercise")
public class Exercise {

    @Transient
    public static final String SEQUENCE_NAME = "exercises_sequence";
    
    @Id
    private long id;
    private String name;
    private int reps;
    private int sets;
    private double weight;
    private String note;

    public Exercise(){

    }
    
    public Exercise(String name, int reps, int sets, double weight, String note) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(long generateSequence) {
    }
}
