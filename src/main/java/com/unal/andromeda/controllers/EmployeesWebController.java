package com.unal.andromeda.controllers;

import com.unal.andromeda.entities.Employee;
import com.unal.andromeda.entities.Enterprise;
import com.unal.andromeda.entities.Profile;
import com.unal.andromeda.entities.Role;
import com.unal.andromeda.repositories.EmployeeRepository;
import com.unal.andromeda.repositories.EnterpriseRepository;
import com.unal.andromeda.repositories.ProfileRepository;
import com.unal.andromeda.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees.html")
public class EmployeesWebController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("newEmployee", new Employee()); // Para el formulario de añadir nuevo empleado

        // Añadir listas para los desplegables
        model.addAttribute("enterprises", enterpriseRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("profiles", profileRepository.findAll());

        return "employees";
    }

    @PostMapping("/new")
    public String createEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("message", "Employee added successfully!");
        return "redirect:/employees.html";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("enterprises", enterpriseRepository.findAll());
            model.addAttribute("roles", roleRepository.findAll());
            model.addAttribute("profiles", profileRepository.findAll());
            return "employee-form"; // Resuelve a src/main/resources/templates/employee-form.html
        }
        return "redirect:/employees.html";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute Employee employeeDetails, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            emp.setCedula(employeeDetails.getCedula());
            emp.setName(employeeDetails.getName());
            emp.setApellido(employeeDetails.getApellido());
            // Los objetos Role, Enterprise, Profile se deben haber enlazado correctamente por sus IDs desde el formulario
            emp.setRole(employeeDetails.getRole());
            emp.setEnterprise(employeeDetails.getEnterprise());
            emp.setProfile(employeeDetails.getProfile());
            employeeRepository.save(emp);
            redirectAttributes.addFlashAttribute("message", "Employee updated successfully!");
        }
        return "redirect:/employees.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Employee deleted successfully!");
        }
        return "redirect:/employees.html";
    }
}
