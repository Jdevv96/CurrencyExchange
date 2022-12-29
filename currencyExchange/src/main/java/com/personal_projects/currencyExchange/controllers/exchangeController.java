package com.personal_projects.currencyExchange.controllers;

import org.jboss.logging.BasicLogger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;

@RestController
@RequestMapping( path = "api/v1/currency")
public class exchangeController {

    // Main api path to get the latest rates
    private static final String API_BASE_PATH = "https://api.exchangerate.host/latest";
    private final RestTemplate restTemplate = new RestTemplate();

    public Currency[] getLatestRates() {
        Currency[] allRates = null;
        try {
            allRates = restTemplate.getForObject(API_BASE_PATH, Currency[].class);
        } catch (ResourceAccessException e) {
            // Catch netork I/O errors
            System.out.println(e.getMessage());
        } catch (RestClientResponseException e) {
            // Catch status code errors
            System.out.println(e.getRawStatusCode());
        }
        return allRates;
    }
}
