package com.example.employeemanagmentsystemapi.services.impl;

import com.example.employeemanagmentsystemapi.entities.Employee;
import com.example.employeemanagmentsystemapi.repository.EmployeeRepository;
import com.example.employeemanagmentsystemapi.services.EmployeeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return  employeeRepository.save(employee) ;
    }

    @Override
    public Employee UpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
