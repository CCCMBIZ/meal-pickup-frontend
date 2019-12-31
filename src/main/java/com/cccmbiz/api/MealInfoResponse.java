package com.cccmbiz.api;

import com.cccmbiz.domain.Meal;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class MealInfoResponse {

    private List<Meal> meals = new ArrayList<>();

    /**
     *
     **/
    @JsonProperty("meals")
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

}
