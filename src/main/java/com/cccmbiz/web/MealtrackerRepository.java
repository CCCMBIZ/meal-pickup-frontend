package com.cccmbiz.web;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MealtrackerRepository extends CrudRepository<Mealtracker, Integer> {

    List<Mealtracker> findByRegistrationIdAndMealType(String registrationId, String mealType);

}
