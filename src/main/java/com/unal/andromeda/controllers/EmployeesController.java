package com.unal.andromeda.controllers;

import com.unal.andromeda.entities.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {
    @RequestMapping(value="/employees")
    public Employee getEmployees() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Enrique");
        employee.setApellido("Vergara");
        employee.setRole("Developer");
        employee.setEnterprise("Londoño Gómez");
        employee.setProfile("kiikechavez");
        return employee;
    }

    @RequestMapping(value="/employees/{id}")
    public Employee getEmployees(@PathVariable Integer id) {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Enrique");
        employee.setApellido("Vergara");
        employee.setRole("Developer");
        employee.setEnterprise("Londoño Gómez");
        employee.setProfile("kiikechavez");
        return employee;
    }

    @RequestMapping(value="/employees")
    public Employee modifyEmployees() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Enrique");
        employee.setApellido("Vergara");
        employee.setRole("Developer");
        employee.setEnterprise("Londoño Gómez");
        employee.setProfile("kiikechavez");
        return employee;
    }

    @RequestMapping(value="/employees")
    public Employee deleteEmployees() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Enrique");
        employee.setApellido("Vergara");
        employee.setRole("Developer");
        employee.setEnterprise("Londoño Gómez");
        employee.setProfile("kiikechavez");
        return employee;
    }

    @RequestMapping(value="/employees")
    public Employee searchEmployees() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Enrique");
        employee.setApellido("Vergara");
        employee.setRole("Developer");
        employee.setEnterprise("Londoño Gómez");
        employee.setProfile("kiikechavez");
        return employee;
    }
}
