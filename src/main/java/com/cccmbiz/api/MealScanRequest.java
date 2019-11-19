package com.cccmbiz.api;


import com.fasterxml.jackson.annotation.JsonProperty;


public class MealScanRequest {

    private Integer personId = null;
    private Integer mealId = null ;


    @JsonProperty("personId")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealScanRequest {\n");

        sb.append("  personId: ").append(personId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
