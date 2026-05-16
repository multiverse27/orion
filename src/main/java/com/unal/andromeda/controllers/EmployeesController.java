package com.unal.andromeda.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {
    @RequestMapping(value="/employees")
    public List<String> empleados(){
        return List.of("Enrique", "Carlos", "Javier");
    }
}
