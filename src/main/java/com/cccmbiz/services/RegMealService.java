package com.cccmbiz.services;

import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.api.MealStatusResponse;
import com.cccmbiz.web.ScanMealException;

public interface RegMealService {
    public MealScanResponse scanMeal(Integer personId) throws ScanMealException;
    public MealStatusResponse checkMeal(Integer personId) throws ScanMealException;
}
