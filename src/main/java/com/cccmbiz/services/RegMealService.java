package com.cccmbiz.services;

import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.api.MealStatusResponse;
import com.cccmbiz.web.ScanMealException;

public interface RegMealService {
    public MealScanResponse scanMeal(String id, Integer mealId) throws ScanMealException;
    public MealStatusResponse checkMeal(String id, Integer mealId) throws ScanMealException;
}
