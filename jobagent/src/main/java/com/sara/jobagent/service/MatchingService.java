package com.sara.jobagent.service;

import com.sara.jobagent.entity.Job;
import com.sara.jobagent.entity.Resume;
import com.sara.jobagent.repository.JobRepository;
import com.sara.jobagent.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MatchingService {

    private final JobRepository jobRepo;
    private final ResumeRepository resumeRepo;

    public MatchingService(JobRepository jobRepo, ResumeRepository resumeRepo) {
        this.jobRepo = jobRepo;
        this.resumeRepo = resumeRepo;
    }

    // הפונקציה הראשית
    public void scoreJobs(Long resumeId) {

        Resume resume = resumeRepo.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Set<String> resumeWords = toWordSet(resume.getContent());

        List<Job> jobs = jobRepo.findAll();

        for (Job job : jobs) {

            Set<String> jobWords = toWordSet(job.getDescription());

            long matches = jobWords.stream()
                    .filter(resumeWords::contains)
                    .count();

            double score = (double) matches / resumeWords.size() * 100;

            job.setScore(Math.round(score * 10.0) / 10.0); // עיגול
        }

        jobRepo.saveAll(jobs);
    }


    // עוזר: ממיר טקסט לסט מילים
    private Set<String> toWordSet(String text) {
        return Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(w -> w.length() > 3)
                .collect(Collectors.toSet());
    }
}
