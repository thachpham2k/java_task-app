package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("nhan-vien")
public class StaffController {

    @GetMapping()
    public ModelAndView index() {
        return new ModelAndView("staff/index");
    }
}
