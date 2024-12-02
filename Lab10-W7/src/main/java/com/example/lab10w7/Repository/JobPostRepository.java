package com.example.lab10w7.Repository;

import com.example.lab10w7.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
}
