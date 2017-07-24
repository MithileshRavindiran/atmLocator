package com.nl.atm.locator.atmlocator.controllers;

import com.nl.atm.locator.atmlocator.configuration.WebApplicationConfig;
import com.nl.atm.locator.atmlocator.controller.ViewController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebApplicationConfig.class})
@WebAppConfiguration
public class ViewControllerTest {

    private ViewController viewController;


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new ViewController())
                .build();
    }

    /**
     * Test the loading of ATM location retriver application
     */
    @Test
    public void testLoad() throws Exception {

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/home"));
    }

    /**
     * Test the loading of ATM location retriver application
     */
    @Test
    public void testLoadAtm() throws Exception {

        this.mockMvc.perform(get("/atm"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/atm"));
    }




}
