package com.cccmbiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MealPlansStatus {

    private List<MealPickUpRecords> pickUpRecord = new ArrayList<MealPickUpRecords>();

    private Integer mealId = null;

    private Integer mealOrdered = null;

    private String description = null;

    private Integer mealTaken = null;

    private Integer mealRemaining = null;


    @JsonProperty("pickUpRecord")
    public List<MealPickUpRecords> getPickUpRecord() {
        return pickUpRecord;
    }

    public void setPickUpRecord(List<MealPickUpRecords> pickUpRecord) {
        this.pickUpRecord = pickUpRecord;
    }

    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @JsonProperty("mealOrdered")
    public Integer getMealOrdered() {
        return mealOrdered;
    }

    public void setMealOrdered(Integer mealOrdered) {
        this.mealOrdered = mealOrdered;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("mealTaken")
    public Integer getMealTaken() {
        return mealTaken;
    }

    public void setMealTaken(Integer mealTaken) {
        this.mealTaken = mealTaken;
    }

    @JsonProperty("mealRemaining")
    public Integer getMealRemaining() {
        return mealRemaining;
    }

    public void setMealRemaining(Integer mealRemaining) {
        this.mealRemaining = mealRemaining;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealPlansStatus {\n");

        sb.append("  pickUpRecord: ").append(pickUpRecord).append("\n");
        sb.append("  mealId: ").append(mealId).append("\n");
        sb.append("  mealOrdered: ").append(mealOrdered).append("\n");
        sb.append("  description: ").append(description).append("\n");
        sb.append("  mealTaken: ").append(mealTaken).append("\n");
        sb.append("  mealRemaining: ").append(mealRemaining).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
