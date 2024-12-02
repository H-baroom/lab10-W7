package com.example.lab10w7.Controller;

import com.example.lab10w7.ApiResponce.ApiResponse;
import com.example.lab10w7.Model.JobApplication;
import com.example.lab10w7.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.IllegalFormatCodePointException;

@RestController
@RequestMapping("/api/v1/jobapplication")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;
    @GetMapping("/get")
    public ResponseEntity getJobApplication() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplication());
    }
    @PostMapping("/applyForJob")
    public ResponseEntity applyForJob(@RequestBody @Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (jobApplicationService.applyForJob(jobApplication)) {
            return ResponseEntity.status(200).body(new ApiResponse("Job application added"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job application not added because user or job not found"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobApplication(@PathVariable Integer id,@RequestBody @Valid JobApplication jobApplication,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (jobApplicationService.updateJobApplication(id, jobApplication)) {
            return ResponseEntity.status(200).body(new ApiResponse("Job application updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job application not found"));
    }

    @DeleteMapping("/withdrawJobApplication/{id}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer id) {
        if (jobApplicationService.withdrawJobApplication(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Job application withdrawn"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job application not found"));
    }
}
