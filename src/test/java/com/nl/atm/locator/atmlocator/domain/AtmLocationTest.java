package com.nl.atm.locator.atmlocator.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AtmLocationTest {

    private AtmLocation atmLocation;

    private GeoLocation geoLocation = new GeoLocation("1.00","25.885");

    private Address address = new Address("pallieterstraat","5","1183LA","AMSTELVEEN",geoLocation);

    private Integer distance = 0;

    private String bank="ABN";

    @Before
    public void setup() {
        atmLocation = new AtmLocation(address,distance,bank);
    }

    @Test
    public void testSettersAndGetters(){
       atmLocation.setAddress(address);
       atmLocation.setDistance(distance);
       atmLocation.setBank(bank);
       assertEquals(bank,atmLocation.getBank());
       assertEquals(distance,atmLocation.getDistance());
       assertEquals(address,atmLocation.getAddress());
    }

    @Test
    public  void testEqualsAndHashCode() {
        AtmLocation atmLoc = new AtmLocation(address,distance,bank);
        GeoLocation geoLocation = new GeoLocation("2.00","25.885");
        Address newAddress = new Address("pallieterstraat","6","1183LA","AMSTELVEEN",geoLocation);

        AtmLocation unMatchAtmLoc = new AtmLocation(newAddress,distance,bank);
        assertTrue(atmLocation.equals(atmLocation));
        assertTrue(atmLoc.equals(atmLocation));
        assertFalse(atmLoc.equals(unMatchAtmLoc));
        assertTrue(atmLocation.hashCode()==atmLocation.hashCode());
        assertTrue(atmLoc.hashCode()==atmLocation.hashCode());
        assertFalse(atmLoc.hashCode()==unMatchAtmLoc.hashCode());
    }
}
