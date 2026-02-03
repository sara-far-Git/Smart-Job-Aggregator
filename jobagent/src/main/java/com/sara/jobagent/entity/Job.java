package com.sara.jobagent.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;

    @Column(length = 5000)
    private String description;

    private String link;

    private Double score; // התאמה באחוזים (0-100)

    @Column(length = 2000)
    private String summary;

    private String sourceEmail;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private LocalDateTime createdAt;


    // ========= Constructors =========

    public Job() {
        this.createdAt = LocalDateTime.now();
        this.status = JobStatus.NEW;
    }


    // ========= Getters & Setters =========

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getSourceEmail() { return sourceEmail; }
    public void setSourceEmail(String sourceEmail) { this.sourceEmail = sourceEmail; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
