package com.nl.atm.locator.atmlocator.utils;

import com.nl.atm.locator.atmlocator.domain.Address;
import com.nl.atm.locator.atmlocator.domain.AtmLocation;
import com.nl.atm.locator.atmlocator.domain.GeoLocation;

import java.util.ArrayList;
import java.util.List;

public final class TestUtils {

    public static List<AtmLocation> createAtmLocation() {
        List<AtmLocation> atmsList = new ArrayList<>();
        GeoLocation geoLocation = new GeoLocation("52.411839","4.684455");
        Address address = new Address("Rosa Spierlaan","72","1187PE","Amstelveen",geoLocation);
        AtmLocation atmLocation = new AtmLocation(address,0,"ING");
        GeoLocation geoLocationAms = new GeoLocation("52.411945","4.684665");
        Address addressAms = new Address("Rosa Spierlaan","79","1187PE","Amsterdam",geoLocation);
        AtmLocation atmLocationAms = new AtmLocation(address,0,"ING");

        atmsList.add(atmLocation);
        atmsList.add(atmLocationAms);

        return  atmsList;
    }
}
