package com.sara.jobagent.service;

import com.sara.jobagent.entity.Resume;
import com.sara.jobagent.repository.ResumeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    private final ResumeRepository repo;
    private final ResumeParserService parser; // ⭐ חדש

    public ResumeService(ResumeRepository repo, ResumeParserService parser) {
        this.repo = repo;
        this.parser = parser;
    }

    public Resume upload(MultipartFile file) throws Exception {

        // ⭐ כאן השינוי החשוב
        String text = parser.extractText(
                file.getOriginalFilename(),
                file.getInputStream()
        );

        String keywords = extractKeywords(text);

        Resume resume = new Resume();
        resume.setFileName(file.getOriginalFilename());
        resume.setContent(text);
        resume.setKeywords(keywords);

        return repo.save(resume);
    }


    private String extractKeywords(String text) {
        return Arrays.stream(text.split("\\W+"))
                .filter(word -> word.length() > 4)
                .limit(50)
                .collect(Collectors.joining(", "));
    }
}
