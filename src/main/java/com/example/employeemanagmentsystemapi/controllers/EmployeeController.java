package com.example.employeemanagmentsystemapi.controllers;

import com.example.employeemanagmentsystemapi.entities.Employee;
import com.example.employeemanagmentsystemapi.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> getEmployees(){
        System.out.println(employeeService.getEmployees());
        return employeeService.getEmployees();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Object addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        if(employee == null) return HttpStatus.BAD_REQUEST;
        return getEmployees();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Employee updateEmployee(@PathVariable Long id , @RequestBody Employee employee){
       var existingEmployee = employeeService.getEmployeeById(id);
       existingEmployee.setEmail(employee.getEmail());
       existingEmployee.setFullName(employee.getFullName());
       employeeService.saveEmployee(existingEmployee);
        return existingEmployee;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    List<Employee> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return getEmployees();
    }

}
