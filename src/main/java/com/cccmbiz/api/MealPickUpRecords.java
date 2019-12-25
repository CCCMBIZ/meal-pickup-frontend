package com.cccmbiz.api;


import com.fasterxml.jackson.annotation.JsonProperty;


public class MealPickUpRecords {

    private String pickUpDate = null;
    private Integer personId = 0;
    private String name = null;

    @JsonProperty("pickUpDate")
    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    @JsonProperty("personId")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealPickUpRecords {\n");

        sb.append("  pickUpDate: ").append(pickUpDate).append("\n");
        sb.append("  personId: ").append(personId).append("\n");
        sb.append("  name: ").append(name).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
