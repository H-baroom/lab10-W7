package com.example.lab10w7.Service;

import com.example.lab10w7.Model.JobApplication;
import com.example.lab10w7.Model.JobPost;
import com.example.lab10w7.Repository.JobApplicationRepository;
import com.example.lab10w7.Repository.JobPostRepository;
import com.example.lab10w7.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;
    public List<JobApplication> getAllJobApplication() {
        return jobApplicationRepository.findAll();
    }
    public Boolean applyForJob(JobApplication jobApplication) {
        if (userRepository.existsById(jobApplication.getUserId())){
            if (jobPostRepository.existsById(jobApplication.getJobPostId())){
                jobApplicationRepository.save(jobApplication);
                return true;
            }
        }
        return false;
    }

    public Boolean updateJobApplication(Integer id,JobApplication jobApplication) {
        List<JobApplication> jobApplications = jobApplicationRepository.findAll();
        for (JobApplication ja : jobApplications) {
            if (ja.getId() == id) {
                ja.setUserId(jobApplication.getUserId());
                ja.setJobPostId(jobApplication.getJobPostId());
                jobApplicationRepository.save(ja);
                return true;
            }
        }
        return false;
    }

    public Boolean withdrawJobApplication(Integer id) {
        if (jobApplicationRepository.existsById(id)) {
            jobApplicationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
