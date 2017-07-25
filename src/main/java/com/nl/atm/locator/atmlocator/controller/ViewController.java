package com.nl.atm.locator.atmlocator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {


    @RequestMapping("/")
    public String home(){
        return "views/home";
    }

    @RequestMapping("/locateAtm")
    public String atmLocationRetriever(){
        return "views/atm";
    }

}
