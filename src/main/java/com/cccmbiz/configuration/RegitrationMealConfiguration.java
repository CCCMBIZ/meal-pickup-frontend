package com.cccmbiz.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Configuration class to load KeyProvider configuration
 * from properties file
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:registration-config.properties"),
})
public class RegitrationMealConfiguration {

    @Value("${provider.service.url}")
    private String providerServiceUrl;

    @Value("${provider.meal.service.url}")
    private String providerMealServiceUrl;

    @Value("${provider.meals.service.url}")
    private String providerMealsServiceUrl;

    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}





