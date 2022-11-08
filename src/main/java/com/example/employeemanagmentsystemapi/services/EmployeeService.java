package com.example.employeemanagmentsystemapi.services;

import com.example.employeemanagmentsystemapi.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee UpdateEmployee(Employee employee);

    void deleteEmployee(Long id);


}
