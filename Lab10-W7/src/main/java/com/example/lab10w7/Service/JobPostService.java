package com.example.lab10w7.Service;

import com.example.lab10w7.Model.JobPost;
import com.example.lab10w7.Model.User;
import com.example.lab10w7.Repository.JobPostRepository;
import com.example.lab10w7.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public List<JobPost> getAllJobPost() {
        return jobPostRepository.findAll();
    }
    public void addJobPost(JobPost jopPost) {
        jobPostRepository.save(jopPost);
    }

    public Boolean updateJobPost(Integer id,JobPost jopPost) {
        List<JobPost> jobPosts = jobPostRepository.findAll();
        for (JobPost jp : jobPosts) {
            if (jp.getId() == id) {
                jp.setTitle(jopPost.getTitle());
                jp.setDescription(jopPost.getDescription());
                jp.setPostingDate(jopPost.getPostingDate());
                jp.setSalary(jopPost.getSalary());
                jp.setLocation(jopPost.getLocation());
                jobPostRepository.save(jp);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteJobPost(Integer id) {
        if (jobPostRepository.existsById(id)) {
            jobPostRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
