package com.sara.jobagent.controller;

import com.sara.jobagent.entity.Job;
import com.sara.jobagent.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping
    public List<Job> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return service.create(job);
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id) {
        return service.getAll()
                .stream()
                .filter(j -> j.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

