package com.cccmbiz.web;

import java.sql.Timestamp;

public class MealTracker {
    public Timestamp getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Timestamp pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Timestamp pickUpDate;
    private String name ;
}
