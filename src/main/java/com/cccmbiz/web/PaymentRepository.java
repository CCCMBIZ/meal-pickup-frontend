package com.cccmbiz.web;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findByRegistrationId(Long registrationId) ;

}
