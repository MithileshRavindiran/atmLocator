package com.nl.atm.locator.atmlocator.services;

import com.nl.atm.locator.atmlocator.domain.AtmLocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AtmLocatorServiceTest {

    @InjectMocks
    private AtmLocatorService atmLocatorService;

    @Mock
    private MockRestServiceServer server;

    @Mock
    private RestTemplate restTemplate;


    private String response = ")]}',\r\n[{\"address\":{\"street\":\"Koningin Julianaplein\",\"housenumber\":\"24\",\"postalcode\":\"2273 BR\",\"city\":\"Voorburg\",\"geoLocation\":{\"lat\":\"52.076097\",\"lng\":\"4.358504\"}},\"distance\":0,\"type\":\"ING\"},{\"address\":{\"street\":\"Friezenstraat\",\"housenumber\":\"14\",\"postalcode\":\"6004 BD\",\"city\":\"Amstelveen\",\"geoLocation\":{\"lat\":\"51.253518\",\"lng\":\"5.734343\"}},\"distance\":0,\"type\":\"ING\"}]";


    /**
     * Test Method to check the success retrival of the atm locations from the mock rest call
     */
    @Test
    public void testSuccessRetrival() {
        List<AtmLocation> atmLocation = new ArrayList<>();
        Mockito.when(restTemplate.getForObject(Matchers.anyString(),Matchers.any())).thenReturn(response);
        try {
            atmLocation =  atmLocatorService.getAtmLocations();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(2, atmLocation.size());
    }

    /**
     * Test Method to check the success retrival of the atm locations based on the requested City from the mock rest call
     */
    @Test
    public void testSuccessRetrivalOfAtmsInCity() {
        List<AtmLocation> atmLocation = new ArrayList<>();
        Mockito.when(restTemplate.getForObject(Matchers.anyString(),Matchers.any())).thenReturn(response);
        try {
             atmLocation =  atmLocatorService.getAtmLocationsfromINGByCity("amstelveen");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, atmLocation.size());
    }

    /**
     *
     * Test Method to check the error retrival of the atm locations from the mock rest call
     *
     */
    @Test
    public void testEmptyResponseRetrival() {
        Mockito.when(restTemplate.getForObject(Matchers.anyString(),Matchers.any())).thenThrow(Exception.class);
        try {
            List<AtmLocation> atmLocation =  atmLocatorService.getAtmLocations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
