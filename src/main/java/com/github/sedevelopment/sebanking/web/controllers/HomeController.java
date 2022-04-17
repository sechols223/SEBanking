package com.github.sedevelopment.sebanking.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping(value="/user")
    public String user() {
        return "user/index";
    }

    @GetMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping(value="/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}
