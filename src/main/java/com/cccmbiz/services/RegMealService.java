package com.cccmbiz.services;

import com.cccmbiz.api.MealInfoResponse;
import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.api.MealStatusResponse;
import com.cccmbiz.domain.Meal;
import com.cccmbiz.web.ScanMealException;

public interface RegMealService {
    public MealScanResponse scanMeal(String id, Integer mealId) throws ScanMealException;
    public MealStatusResponse checkMeal(String id) throws ScanMealException;
    public MealInfoResponse getMeals(Integer location) throws ScanMealException;
}
