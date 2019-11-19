package com.cccmbiz.api;


import com.fasterxml.jackson.annotation.JsonProperty;



public class MealStatusRequest {

    private Integer personId = null;

    private Integer familyId = null;

    private Integer mealId = null;

    @JsonProperty("personId")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @JsonProperty("familyId")
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    @JsonProperty("mealId")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer phoneNumber) {
        this.mealId = mealId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealStatusRequest {\n");

        sb.append("  personId: ").append(personId).append("\n");
        sb.append("  familyId: ").append(familyId).append("\n");
        sb.append("  MealId: ").append(mealId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
