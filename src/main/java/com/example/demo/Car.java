package com.example.demo;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "cars")
public class Car {
    
    // properties
    @Id
    @Column( name = "car_id")
    @JsonProperty
    @NotEmpty
    public String car_id;

    @Column(name = "make")
    @JsonProperty
    public String make;
    
    @Column(name = "model")
    @JsonProperty
    public String model;
    
    @Column(name = "color")
    @JsonProperty
    public String color;

    @Column(name = "year")
    @JsonProperty
    public String year;

    @Column(name = "imgurl")
    @JsonProperty
    public String imgurl;
    
    @Column(name = "powerwindows")
    @JsonProperty
    public String powerwindows;
    
    @Column(name = "powerlocks")
    @JsonProperty
    public String powerlocks;
    
    @Column(name = "backupcamera")
    @JsonProperty
    public String backupcamera;

    // empty constructor
    public Car() {
    }

    // jon todo: update comment
    public Car(String car_id, String make, String model) {
        this.car_id = car_id;
        this.make = make;
        this.model = model;
    }

    // getters and setters
    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPowerwindows() {
        return powerwindows;
    }

    public void setPowerwindows(String powerwindows) {
        this.powerwindows = powerwindows;
    }

    public String getPowerlocks() {
        return powerlocks;
    }

    public void setPowerlocks(String powerlocks) {
        this.powerlocks = powerlocks;
    }

    public String getBackupcamera() {
        return backupcamera;
    }

    public void setBackupcamera(String backupcamera) {
        this.backupcamera = backupcamera;
    }

}
