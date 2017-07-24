package com.nl.atm.locator.atmlocator.controllers;

import com.nl.atm.locator.atmlocator.controller.AtmLocationRetriveController;
import com.nl.atm.locator.atmlocator.domain.AtmLocation;
import com.nl.atm.locator.atmlocator.services.AtmLocatorService;
import com.nl.atm.locator.atmlocator.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AtmLocationRetriveControllerTest {

    @InjectMocks
    private AtmLocationRetriveController atmLocationRetriveController;

    @Mock
    private AtmLocatorService atmLocatorService;

    private List<AtmLocation> atmLocations;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        atmLocations = TestUtils.createAtmLocation();;
    }

    @Test
    public void testGetATMLocationsfromSuccess() throws Exception {

        when(atmLocatorService.getAtmLocations()).thenReturn(atmLocations);
        List<AtmLocation> atmLocationsfromING = atmLocationRetriveController.getATMLocations();
        assertEquals(atmLocationsfromING.size(),2);

    }
}
