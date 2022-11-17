package com.example.employeemanagmentsystemapi.services.impl;

import com.example.employeemanagmentsystemapi.entities.Job;
import com.example.employeemanagmentsystemapi.repository.JobRepository;
import com.example.employeemanagmentsystemapi.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
       return this.jobRepository.findAll();
    }

    @Override
    public Job getOneJob(Long id) {
        return this.jobRepository.findById(id).get();
    }

    @Override
    public Job save(Job job) {
        return this.jobRepository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return this.jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
      this.jobRepository.deleteById(id);
    }
}
