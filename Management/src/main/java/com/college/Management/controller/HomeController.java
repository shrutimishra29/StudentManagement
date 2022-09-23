package com.college.Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    //Request mapping for home page
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    //Request mapping for home page
    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    //Request Mapping for help page
    @RequestMapping("/help")
    public String help() {
        return "faq";
    }

    //Request Mapping for contact page
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

}