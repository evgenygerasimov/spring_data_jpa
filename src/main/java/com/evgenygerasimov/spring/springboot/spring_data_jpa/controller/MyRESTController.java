package com.evgenygerasimov.spring.springboot.spring_data_jpa.controller;


import com.evgenygerasimov.spring.springboot.spring_data_jpa.entity.Employee;
import com.evgenygerasimov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    final EmployeeService employeeService;

    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {

        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
//        if (employee == null) {
//            throw new NoSuchEmployeeException("There is no employee with id " + id + " in the database");
//        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
//        if (employeeService.getEmployeeById(id) == null) {
//            throw new NoSuchEmployeeException("There is no employee with id " + id + " in the database");
//        }
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " deleted successfully";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }
}
