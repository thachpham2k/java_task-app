package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping()
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping(value = "trang-chu")
    public ModelAndView home2() {
        return new ModelAndView("index");
    }
}
