package com.sara.jobagent.repository;

import com.sara.jobagent.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findAllByOrderByScoreDesc();

}
