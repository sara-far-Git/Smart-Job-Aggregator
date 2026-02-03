package com.sara.jobagent.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @Column(length = 10000)
    private String content; // הטקסט המלא של הקו"ח

    @Column(length = 2000)
    private String keywords; // מילים חשובות שחילצנו

    private LocalDateTime uploadedAt;


    public Resume() {
        this.uploadedAt = LocalDateTime.now();
    }

    // ===== getters/setters =====

    public Long getId() { return id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getKeywords() { return keywords; }
    public void setKeywords(String keywords) { this.keywords = keywords; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
}
