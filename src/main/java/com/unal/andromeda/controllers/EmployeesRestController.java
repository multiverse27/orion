package com.unal.andromeda.controllers;

import com.unal.andromeda.entities.Employee;
import com.unal.andromeda.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeesRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<Employee> getEmployeeByCedula(@PathVariable String cedula) {
        Optional<Employee> employee = employeeRepository.findByCedula(cedula);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            emp.setCedula(employeeDetails.getCedula());
            emp.setName(employeeDetails.getName());
            emp.setApellido(employeeDetails.getApellido());
            emp.setRole(employeeDetails.getRole());
            emp.setEnterprise(employeeDetails.getEnterprise());
            emp.setProfile(employeeDetails.getProfile());
            Employee updatedEmployee = employeeRepository.save(emp);
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

