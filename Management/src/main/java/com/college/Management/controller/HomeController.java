package com.college.Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/help")
    public String help() {
        return "faq";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

}