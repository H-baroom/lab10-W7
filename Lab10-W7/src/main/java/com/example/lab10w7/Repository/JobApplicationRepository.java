package com.example.lab10w7.Repository;

import com.example.lab10w7.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
}
