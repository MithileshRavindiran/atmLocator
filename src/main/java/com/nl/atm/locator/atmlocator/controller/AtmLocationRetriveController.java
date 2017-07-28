package com.nl.atm.locator.atmlocator.controller;

import com.nl.atm.locator.atmlocator.domain.AtmLocation;
import com.nl.atm.locator.atmlocator.services.AtmLocatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring's Rest Contoller exposes Rest services to get list of atm locations in the country
 */
@RestController
public class AtmLocationRetriveController {

    @Autowired
    private AtmLocatorService atmLocatorService;


    /**
     * Method to get All Atm's Location
     * @return list of Atm Location {@link AtmLocation}
     * @throws Exception
     */
    @GetMapping(value = "/getAtmLocations", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AtmLocation> getATMLocations()  {
        List<AtmLocation> atmLocations = new ArrayList<>();
        try {
            atmLocations = atmLocatorService.getAtmLocations();
        } catch (Exception e) {
            atmLocations = null;
            e.printStackTrace();
        }
        return atmLocations;
    }
}
