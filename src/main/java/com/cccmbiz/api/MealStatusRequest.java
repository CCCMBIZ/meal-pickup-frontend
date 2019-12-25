package com.cccmbiz.api;


import com.fasterxml.jackson.annotation.JsonProperty;



public class MealStatusRequest {

    private String id = null;
    private Integer mealId = null;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealStatusRequest {\n");

        sb.append("  Scanned ID: ").append(id).append("\n");
        sb.append("  Meal ID: ").append(mealId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
