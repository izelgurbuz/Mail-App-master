package com.beam.sample.mail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/","/mail","/user","/change-pass"})
    public String index() {
        return "index";
    }
}
