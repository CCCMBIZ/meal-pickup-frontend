package com.cccmbiz.services;

import com.cccmbiz.api.MealScanRequest;
import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.api.MealStatusRequest;
import com.cccmbiz.api.MealStatusResponse;
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
 *  EventManagerServiceImpl service
 **/
@Service
public class RegMealServiceImpl implements RegMealService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestTemplate restTemplate;

    @Value("${provider.service.url}")
    String serviceUrl;

    @Value("${provider.meal.service.url}")
    private String providerMealServiceUrl;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * This method is used to init RestTemplate object;
     */
    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
        for (HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters())  {
            logger.info (httpMessageConverter.toString());
        }
        restTemplate.setMessageConverters(getMessageConverters());
        logger.info("--------- After ----------");
        for (HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters())  {
            logger.info (httpMessageConverter.toString());
        }
    }

    public MealStatusResponse checkMeal(Integer personId) throws ScanMealException {
        logger.info("person ID: " + personId);

        MealStatusRequest request = new MealStatusRequest();
        request.setPersonId(personId);

        MealStatusResponse response = restTemplate.postForObject(providerMealServiceUrl, request, MealStatusResponse.class);

        return response;
    }


    public MealScanResponse scanMeal(Integer personId) throws ScanMealException {

        logger.info("person ID: " + personId);

        MealScanRequest request = new MealScanRequest();
        request.setPersonId(personId);

//        ResponseEntity<MealScanResponse> responseEntity;
        try {
            MealScanResponse response = restTemplate.postForObject(serviceUrl, request, MealScanResponse.class);
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException httpError) {

            logger.error("HTTP Error:" + httpError.getStatusCode() + " " + httpError.getMessage());
            if(HttpStatus.NOT_FOUND.equals(httpError.getStatusCode())) {
                throw new NoSuchElementException("No Record for Person ID " + personId);
            } else if (HttpStatus.SERVICE_UNAVAILABLE.equals(httpError.getStatusCode())) {
                throw new ScanMealException("Service Error:" + httpError.getMessage());
            } else {
                throw new ScanMealException("Error:" + httpError.getMessage());
            }
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