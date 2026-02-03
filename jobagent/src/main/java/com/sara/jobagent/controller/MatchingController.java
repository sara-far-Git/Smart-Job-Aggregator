package com.sara.jobagent.controller;

import com.sara.jobagent.service.MatchingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matching")
@CrossOrigin
public class MatchingController {

    private final MatchingService service;

    public MatchingController(MatchingService service) {
        this.service = service;
    }

    @PostMapping("/{resumeId}")
    public String match(@PathVariable Long resumeId) {

        service.scoreJobs(resumeId);

        return "Matching completed successfully";
    }
}
