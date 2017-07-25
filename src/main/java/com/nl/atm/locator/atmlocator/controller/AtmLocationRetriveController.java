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

@RestController
public class AtmLocationRetriveController {

    @Autowired
    private AtmLocatorService atmLocatorService;


    @GetMapping(value = "/getAtmLocations", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AtmLocation> getATMLocations() throws Exception {
        List<AtmLocation> responseObject= new ArrayList<>();
        responseObject = atmLocatorService.getAtmLocations();
        return responseObject;
    }
}
