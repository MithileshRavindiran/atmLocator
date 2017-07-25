package com.nl.atm.locator.atmlocator.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nl.atm.locator.atmlocator.domain.AtmLocation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class AtmLocatorService {

    @Resource(name = "atmLocatorRestTemplate")
    private RestTemplate restTemplate;

    public List<AtmLocation> getAtmLocations() throws Exception {

        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
        List<AtmLocation> atmLocations = new ArrayList<>();
        if (response != null) {
            String validResponse = response.substring(6, response.length());
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<AtmLocation>> mapType = new TypeReference<List<AtmLocation>>(){};
            atmLocations = objectMapper.readValue(validResponse, mapType);
        }
        return atmLocations;
    }

}
