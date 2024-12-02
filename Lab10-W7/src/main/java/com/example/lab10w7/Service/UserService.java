package com.example.lab10w7.Service;

import com.example.lab10w7.Model.User;
import com.example.lab10w7.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public Boolean updateUser(Integer id,User user) {
        List<User> allUsers = userRepository.findAll();
        for (User u : allUsers) {
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setPassword(user.getPassword());
                u.setRole(user.getRole());
                u.setAge(user.getAge());
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
