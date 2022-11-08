package com.example.employeemanagmentsystemapi.repository;

import com.example.employeemanagmentsystemapi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
