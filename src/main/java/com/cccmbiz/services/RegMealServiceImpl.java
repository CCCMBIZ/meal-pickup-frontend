package com.cccmbiz.services;

import com.cccmbiz.api.*;
import com.cccmbiz.domain.Meal;
import com.cccmbiz.web.ScanMealException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * EventManagerServiceImpl service
 **/
@Service
public class RegMealServiceImpl implements RegMealService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestTemplate restTemplate;

    @Value("${provider.service.url}")
    private String serviceUrl;

    @Value("${provider.meal.service.url}")
    private String providerMealServiceUrl;

    @Value("${provider.meals.service.url}")
    private String providerMealsServiceUrl;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * This method is used to init RestTemplate object;
     */
    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
        for (HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters()) {
            logger.info(httpMessageConverter.toString());
        }
        restTemplate.setMessageConverters(getMessageConverters());
        logger.info("--------- After ----------");
        for (HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters()) {
            logger.info(httpMessageConverter.toString());
        }
    }

    @Override
    public MealStatusResponse checkMeal(String id) throws ScanMealException {

        logger.info("Check all meals for Scanned ID: " + id );

        MealStatusRequest request = new MealStatusRequest();
        request.setId(id);

        try {
            ResponseEntity<MealStatusResponse> responseEntity = restTemplate.getForEntity(providerMealServiceUrl + "/" + request.getId(), MealStatusResponse.class);
            logger.error("HTTP Status Code:" + responseEntity.getStatusCode() + " " + responseEntity.getStatusCodeValue());

            if (HttpStatus.NOT_FOUND.equals(responseEntity.getStatusCode())) {
                throw new NoSuchElementException("No Record for Scanned ID " + id);
            } else if (HttpStatus.SERVICE_UNAVAILABLE.equals(responseEntity.getStatusCode())) {
                throw new ScanMealException("Service Unavailable Error. Unable to process " + id);
            }

            return responseEntity.getBody();

        } catch (ResourceAccessException resourceError) {
            throw new ScanMealException("Service Error:" + resourceError.getMessage());
        } catch (HttpClientErrorException httpClientError) {
            throw new ScanMealException("Service Error:" + httpClientError.getMessage());
        }
    }

    @Override
    public MealScanResponse scanMeal(String id, Integer mealId) throws ScanMealException {

        logger.info("Scanned ID: " + id + " Meal ID: " + mealId);

        MealScanRequest request = new MealScanRequest();
        request.setId(id);
        request.setMealId(mealId);

        try {
            MealScanResponse response = restTemplate.postForObject(serviceUrl, request, MealScanResponse.class);
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException httpError) {

            logger.error("HTTP Error:" + httpError.getStatusCode() + " " + httpError.getMessage());
            if (HttpStatus.NOT_FOUND.equals(httpError.getStatusCode())) {
                throw new NoSuchElementException("No Record for Scanned ID " + id);
            } else if (HttpStatus.SERVICE_UNAVAILABLE.equals(httpError.getStatusCode())) {
                throw new ScanMealException("Service Error:" + httpError.getMessage());
            } else {
                throw new ScanMealException("Error:" + httpError.getMessage());
            }
        } catch (ResourceAccessException resourceError) {
            throw new ScanMealException("Service Error:" + resourceError.getMessage());
        }

    }

    @Override
    public MealInfoResponse getMeals(Integer location) throws ScanMealException {

        logger.info(" Meal Location: " + location);

        try {
            ResponseEntity<MealInfoResponse> responseEntity = restTemplate.getForEntity(providerMealsServiceUrl + "/" + location, MealInfoResponse.class);
            logger.error("HTTP Status Code:" + responseEntity.getStatusCode() + " " + responseEntity.getStatusCodeValue());

            MealInfoResponse response = responseEntity.getBody();

            if (HttpStatus.NOT_FOUND.equals(responseEntity.getStatusCode())) {
                throw new NoSuchElementException("No Record for location " + location);
            } else if (HttpStatus.SERVICE_UNAVAILABLE.equals(responseEntity.getStatusCode())) {
                throw new ScanMealException("Service Unavailable Error. Unable to process location " + location);
            }

            return response ;

        } catch (ResourceAccessException resourceError) {
            throw new ScanMealException("Service Error:" + resourceError.getMessage());
        }
    }

    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }
}
