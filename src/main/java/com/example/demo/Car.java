package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    
    private long id;
    private String make;
    private String model;
    private String year;
    private String color;
    private String imgurl;
    private String powerwindows;
    private String powerlocks;
    private String backupcamera;

    // default constructor
    public Car() {
    }

    // parameterized constructor
    public Car(
        String make, 
        String model, 
        String year, 
        String color, 
        String imgurl,
        String powerwindows,
        String powerlocks,
        String backupcamera
        ) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.imgurl = imgurl;
        this.powerwindows = powerwindows;
        this.powerlocks = powerlocks;
        this.backupcamera = backupcamera;
    }

    // getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year")
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "imgurl")
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Column(name = "powerwindows")
    public String getPowerwindows() {
        return powerwindows;
    }
    public void setPowerwindows(String powerwindows) {
        this.powerwindows = powerwindows;
    }

    @Column(name = "powerlocks")
    public String getPowerlocks() {
        return powerlocks;
    }
    public void setPowerlocks(String powerlocks) {
        this.powerlocks = powerlocks;
    }

    @Column(name = "backupcamera")
    public String getBackupcamera() {
        return backupcamera;
    }
    public void setBackupcamera(String backupcamera) {
        this.backupcamera = backupcamera;
    }

}