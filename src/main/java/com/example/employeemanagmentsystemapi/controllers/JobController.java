package com.example.employeemanagmentsystemapi.controllers;

import com.example.employeemanagmentsystemapi.entities.Job;
import com.example.employeemanagmentsystemapi.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Job> getAllJobs(){
        return this.jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Job getOneJob(@PathVariable Long id){
        return this.jobService.getOneJob(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    List<Job> addJob(@RequestBody Job job){
        this.jobService.save(job);
        return this.getAllJobs();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Job> updateJob(@RequestBody Job job , @PathVariable Long id){
       var oldJob =  this.jobService.getOneJob(id);
       oldJob.setJobName(job.getJobName());
        this.jobService.save(oldJob);
        return this.getAllJobs();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<Job> deleteJob(@PathVariable Long id){
        this.jobService.deleteJob(id);
        return this.getAllJobs();
    }



}
