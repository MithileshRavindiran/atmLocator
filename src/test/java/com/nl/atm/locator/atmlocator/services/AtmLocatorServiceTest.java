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

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AtmLocatorServiceTest {

    @InjectMocks
    private AtmLocatorService atmLocatorService;

    @Mock
    private MockRestServiceServer server;

    @Mock
    private RestTemplate restTemplate;


    private String response = ")]}',\r\n[{\"address\":{\"street\":\"Koningin Julianaplein\",\"housenumber\":\"24\",\"postalcode\":\"2273 BR\",\"city\":\"Voorburg\",\"geoLocation\":{\"lat\":\"52.076097\",\"lng\":\"4.358504\"}},\"distance\":0,\"type\":\"ING\"},{\"address\":{\"street\":\"Friezenstraat\",\"housenumber\":\"14\",\"postalcode\":\"6004 BD\",\"city\":\"Weert\",\"geoLocation\":{\"lat\":\"51.253518\",\"lng\":\"5.734343\"}},\"distance\":0,\"type\":\"ING\"}]";


    @Test
    public void testSuccessRetrival() {
        //define the entity you want the exchange to return
        Mockito.when(restTemplate.getForObject(Matchers.anyString(),Matchers.any())).thenReturn(response);
        try {
           List<AtmLocation> atmLocation =  atmLocatorService.getAtmLocations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEmptyResponseRetrival() {
        //define the entity you want the exchange to return
        Mockito.when(restTemplate.getForObject(Matchers.anyString(),Matchers.any())).thenReturn(null);
        try {
            List<AtmLocation> atmLocation =  atmLocatorService.getAtmLocations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
