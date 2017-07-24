package com.nl.atm.locator.atmlocator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("pageTitle","My Custom Page Title");
        model.addAttribute("posts",null);
        return "views/list";
    }

    @RequestMapping("/")
    public String home(){
        return "views/home";
    }

    @RequestMapping("/atm")
    public String atmLocationRetriever(){
        return "views/atm";
    }

}
