package com.nl.atm.locator.atmlocator.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nl.atm.locator.atmlocator.domain.AtmLocation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * AtmLocatorService is class that consumes the third party rest service and provides the
 */
@Service
public class AtmLocatorService {

    @Resource(name = "atmLocatorRestTemplate")
    private RestTemplate restTemplate;

    /**
     * Method to get all ATM locations by calling a rest template service
     *
     * @return list of AtmLocation
     * @throws Exception
     */
    public List<AtmLocation> getAtmLocations() throws Exception {

        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
        List<AtmLocation> atmLocations = new ArrayList<>();
        if (response != null) {
            String validResponse = response.substring(6, response.length());
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<AtmLocation>> mapType = new TypeReference<List<AtmLocation>>() {
            };
            atmLocations = objectMapper.readValue(validResponse, mapType);
        }
        return atmLocations;
    }


    /**
     * Method that accepts a city as a parameter and provides the list of atm locations
     * in that city
     *
     * @param city of type String
     * @return list of AtmLocation {@link AtmLocation}
     * @throws Exception
     */
    public List<AtmLocation> getAtmLocationsfromINGByCity(String city) throws Exception {
        List<AtmLocation> locations = new ArrayList<>();
        List<AtmLocation> atmLocations = getAtmLocations();
        for (AtmLocation location : atmLocations) {
            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
                locations.add(location);
            }
        }
        return locations;
    }

}
