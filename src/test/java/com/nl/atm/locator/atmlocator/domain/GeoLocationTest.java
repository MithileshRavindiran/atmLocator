package com.nl.atm.locator.atmlocator.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GeoLocationTest {

    private GeoLocation geoLocation;

    private String latitude;

    private String longitude;

    @Before
    public void setup() {
        geoLocation = new GeoLocation();
        latitude="52.076097";
        longitude="4.358504";
    }

    @Test
    public void testGettersAndSetters() {
        geoLocation.setLatitude(latitude);
        geoLocation.setLongitude(longitude);
        assertEquals(latitude,geoLocation.getLatitude());
        assertEquals(longitude,geoLocation.getLongitude());
    }

    @Test
    public void testEqualsAndString() {
        geoLocation.setLatitude(latitude);
        geoLocation.setLongitude(longitude);
        GeoLocation newGeoLocation = new GeoLocation(latitude,longitude);
        GeoLocation geoLocate = new GeoLocation("4.358505","52.076099");
        assertTrue(geoLocation.equals(newGeoLocation));
        assertTrue(geoLocation.hashCode()==newGeoLocation.hashCode());
        assertTrue(geoLocation.equals(geoLocation));
        assertTrue(geoLocation.hashCode()==geoLocation.hashCode());
        assertFalse(geoLocation.equals(geoLocate));
        assertFalse(geoLocation.hashCode()==geoLocate.hashCode());
        assertEquals("GeoLocation{latitude='4.358505', longitude='52.076099'}",geoLocation.toString());
    }


}
