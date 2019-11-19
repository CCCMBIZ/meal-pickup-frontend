package com.cccmbiz.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class MealScanResponse {


    private Integer mealOrdered = null;


    private Integer mealTaken = null;


    private Integer mealRemaining = null;


    private List<MealPickUpRecords> pickUpRecord = new ArrayList<MealPickUpRecords>();



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

        sb.append("  mealOrdered: ").append(mealOrdered).append("\n");
        sb.append("  mealTaken: ").append(mealTaken).append("\n");
        sb.append("  mealRemaining: ").append(mealRemaining).append("\n");
        sb.append("  pickUpRecord: ").append(pickUpRecord).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
