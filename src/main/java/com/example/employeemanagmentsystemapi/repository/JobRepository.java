package com.example.employeemanagmentsystemapi.repository;

import com.example.employeemanagmentsystemapi.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
