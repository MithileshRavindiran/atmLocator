package com.nl.atm.locator.atmlocator.controller;

import com.nl.atm.locator.atmlocator.services.AtmLocatorService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * Class to Configure  Rest end point and Swagger for a fidnding the list of atms by city
 */
@Component
public class CityAtmsLocationRetriverController extends RouteBuilder {
    @Override
    public void configure() {
        restConfiguration()
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .bindingMode(RestBindingMode.json);

        rest("/findAtms").description(" rest service for get atm locations on a city ")
                .get("/{city}").description("The list of all automatic teller machine in a city")
                .route().routeId("atms-api")
                .bean(AtmLocatorService.class, "getAtmLocationsfromINGByCity(${header.city})");
    }
}
