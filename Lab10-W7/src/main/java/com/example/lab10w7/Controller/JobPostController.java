package com.example.lab10w7.Controller;

import com.example.lab10w7.ApiResponce.ApiResponse;
import com.example.lab10w7.Model.JobPost;
import com.example.lab10w7.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobpost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getJobPosts() {
        return ResponseEntity.status(200).body(jobPostService.getAllJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job Post added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (jobPostService.updateJobPost(id, jobPost)) {
            return ResponseEntity.status(200).body(new ApiResponse("Job Post updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job Post not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id) {
        if (jobPostService.deleteJobPost(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Job Post deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job Post not found"));
    }
}
