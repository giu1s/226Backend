package com.sports.plan.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;


@Document("measurement")
public class Measurement {

    @Id
    private UUID id;
    private Date date;
    private double weight;
    private double bodyFat;
    private double waist;
    private double belly;
    private double chest;
    private double hips;

    public Measurement(){

    }
    public Measurement( Date date, double weight, double bodyFat, double waist, double belly, double chest,
            double hips) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.weight = weight;
        this.bodyFat = bodyFat;
        this.waist = waist;
        this.belly = belly;
        this.chest = chest;
        this.hips = hips;
    }
    public UUID getId() {
        return id;
    }
  
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getBodyFat() {
        return bodyFat;
    }
    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }
    public double getWaist() {
        return waist;
    }
    public void setWaist(double waist) {
        this.waist = waist;
    }
    public double getBelly() {
        return belly;
    }
    public void setBelly(double belly) {
        this.belly = belly;
    }
    public double getChest() {
        return chest;
    }
    public void setChest(double chest) {
        this.chest = chest;
    }
    public double getHips() {
        return hips;
    }
    public void setHips(double hips) {
        this.hips = hips;
    }



}
