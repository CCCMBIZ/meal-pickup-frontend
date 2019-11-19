package com.cccmbiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class MealStatusResponse {

    private Integer familyId = null;

    private List<MealPlansStatus> mealPlans = new ArrayList<MealPlansStatus>();

    @JsonProperty("familyId")
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyID) {
        this.familyId = familyId;
    }

    @JsonProperty("mealPlans")
    public List<MealPlansStatus> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(List<MealPlansStatus> mealPlans) {
        this.mealPlans = mealPlans;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MealStatusResponse {\n");

        sb.append("  familyId: ").append(familyId).append("\n");
        sb.append("  mealPlans: ").append(mealPlans).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
