package com.cccmbiz.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class MealScanResponse {

    private Integer mealId = null ;
    private Integer mealOrdered = null;
    private Integer mealTaken = null;
    private Integer mealRemaining = null;
    private Integer mealStatus = null ;

    private List<MealPickUpRecords> pickUpRecord = new ArrayList<MealPickUpRecords>();

    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @JsonProperty("mealStatus")
    public Integer getMealStatus() {
        return mealStatus;
    }

    public void setMealStatus(Integer mealStatus) {
        this.mealStatus = mealStatus;
    }

    @JsonProperty("mealOrdered")
    public Integer getMealOrdered() {
        return mealOrdered;
    }

    public void setMealOrdered(Integer mealOrdered) {
        this.mealOrdered = mealOrdered;
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

    @JsonProperty("pickUpRecord")
    public List<MealPickUpRecords> getPickUpRecord() {
        return pickUpRecord;
    }

    public void setPickUpRecord(List<MealPickUpRecords> pickUpRecord) {
        this.pickUpRecord = pickUpRecord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealScanResponse {\n");

        sb.append("  mealId: ").append(mealId).append("\n");
        sb.append("  mealOrdered: ").append(mealOrdered).append("\n");
        sb.append("  mealTaken: ").append(mealTaken).append("\n");
        sb.append("  mealRemaining: ").append(mealRemaining).append("\n");
        sb.append("  mealStatus: ").append(mealStatus).append("\n");
        sb.append("  pickUpRecord: ").append(pickUpRecord).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
