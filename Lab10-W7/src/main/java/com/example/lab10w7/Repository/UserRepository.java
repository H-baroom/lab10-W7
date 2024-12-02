package com.example.lab10w7.Repository;

import com.example.lab10w7.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
