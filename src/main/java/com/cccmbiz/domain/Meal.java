package com.cccmbiz.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;


public class Meal {
    private int id;
    private String uid;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Timestamp deadline;
    private byte type;
    private byte location;
    private String food;
    private BigDecimal price;
    private Event eventByEventId;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonProperty("startTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("endTime")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("deadLine")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @JsonProperty("type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @JsonProperty("location")
    public byte getLocation() {
        return location;
    }

    public void setLocation(byte location) {
        this.location = location;
    }

    @JsonProperty("food")
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @JsonProperty("price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return id == meal.id &&
                type == meal.type &&
                location == meal.location &&
                Objects.equals(uid, meal.uid) &&
                Objects.equals(date, meal.date) &&
                Objects.equals(startTime, meal.startTime) &&
                Objects.equals(endTime, meal.endTime) &&
                Objects.equals(deadline, meal.deadline) &&
                Objects.equals(food, meal.food) &&
                Objects.equals(price, meal.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, date, startTime, endTime, deadline, type, location, food, price);
    }

    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }
}
