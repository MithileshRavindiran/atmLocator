package com.nl.atm.locator.atmlocator.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AddressTest {

    private Address address;

    private String street = "Pallieterstraat";

    private String houseNumber = "5";

    private String postalCode = "1183LA";

    private String city = "Amstelveen";

    private GeoLocation geoLocation = new GeoLocation("4.358505","52.076099");

    @Before
    public void setup() {
        address = new Address(street,houseNumber,postalCode,city,geoLocation);
    }

    @Test
    public void testGettersAndSetters() {
            address.setCity(city);
            address.setGeoLocation(geoLocation);
            address.setHousenumber(houseNumber);
            address.setPostalcode(postalCode);
            address.setStreet(street);
            assertEquals(city,address.getCity());
            assertEquals(geoLocation,address.getGeoLocation());
            assertEquals(houseNumber,address.getHousenumber());
            assertEquals(postalCode,address.getPostalcode());
            assertEquals(city,address.getCity());
            assertEquals(street,address.getStreet());
    }
    @Test
    public void testEqualsAndHashCode() {
        Address newAddress = new Address(street,houseNumber,postalCode,city,geoLocation);
        Address addressRotterdam = new Address(street,houseNumber,postalCode,"Rotterdam",geoLocation);
        assertTrue(address.equals(address));
        assertFalse(address.equals(newAddress));
        assertFalse(address.equals(addressRotterdam));
        assertTrue(address.hashCode()==address.hashCode());
        assertTrue(address.hashCode()==newAddress.hashCode());
        assertFalse(address.hashCode()==addressRotterdam.hashCode());
    }
}