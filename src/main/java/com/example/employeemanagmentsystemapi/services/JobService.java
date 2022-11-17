package com.example.employeemanagmentsystemapi.services;

import com.example.employeemanagmentsystemapi.entities.Job;

import java.io.Serializable;
import java.util.List;

public interface JobService extends Serializable {
    List<Job> getAllJobs();
    Job getOneJob(Long id);
    Job save(Job job);
    Job updateJob(Job job);
    void deleteJob(Long id);
}
