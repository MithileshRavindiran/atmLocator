package com.nl.atm.locator.atmlocator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * View Controller handles the rendering of web pages based on the request from the client
 */
@Controller
public class ViewController {


    @RequestMapping("/")
    public String home() {
        return "views/home";
    }

    @RequestMapping("/locateAllAtms")
    public String allAtmLocationRetriever() {
        return "views/atm";
    }

    @RequestMapping("/locateCityAtms")
    public String cityAtmLocationRetriever() {
        return "views/cityAtm";
    }

}
