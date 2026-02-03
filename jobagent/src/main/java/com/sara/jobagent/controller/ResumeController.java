package com.sara.jobagent.controller;

import com.sara.jobagent.entity.Resume;
import com.sara.jobagent.service.ResumeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/resume")
@CrossOrigin
public class ResumeController {

    private final ResumeService service;

    public ResumeController(ResumeService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public Resume upload(@RequestParam("file") MultipartFile file) throws Exception {
        return service.upload(file);
    }
}
