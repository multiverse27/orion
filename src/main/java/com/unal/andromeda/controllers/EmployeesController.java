package com.unal.andromeda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeesController {

    @GetMapping("/")
    public String index() {
        return "redirect:/";
    }
}
