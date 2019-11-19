package com.cccmbiz.services;

import com.cccmbiz.api.MealScanRequest;
import com.cccmbiz.api.MealScanResponse;
import com.cccmbiz.web.ScanMealException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class RegMealServiceImplTest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RegMealServiceImpl regMealServiceImpl ;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private MealScanResponse mealScanResponse;
    @Mock
    private MealScanRequest mealScanRequest;

    private String serviceUrl = "http://localhost:8080/meal/scan";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        regMealServiceImpl = new RegMealServiceImpl();
        regMealServiceImpl.setRestTemplate(restTemplate);
    }

//    @Test
//    public void scanMeal() throws ScanMealException {
//        // Arrange
//        when(restTemplate.postForObject(serviceUrl, mealScanRequest, MealScanResponse.class)).thenReturn(mealScanResponse);
//        // Act
//        MealScanResponse response = regMealServiceImpl.scanMeal(999);
//        // Assert
//        assertThat(response, is(equalTo(response.getMealOrdered())));
//    }

    @Test
    public void testDateFormat() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            // you can change format of date
            Date date = formatter.parse("2019-11-01T13:48:45.984-05:00");
            Timestamp timeStampDate = new Timestamp(date.getTime());

            logger.debug("TestDate:" + timeStampDate.toString());

        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            fail() ;
        }

    }
}