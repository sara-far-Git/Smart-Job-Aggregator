package com.sara.jobagent.service;

import com.sara.jobagent.entity.Job;
import com.sara.jobagent.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public List<Job> getAll() {
        return repository.findAll();
    }

    public Job create(Job job) {
        return repository.save(job);
    }

    public void delete(Long id) {
    repository.deleteById(id);
}
public List<Job> getSorted() {
    return repository.findAllByOrderByScoreDesc();
}

}
