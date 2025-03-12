package com.example.QueryService.Service;

import com.example.QueryService.Entity.User;
import com.example.QueryService.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get All Users
    public Map<String, Object> getAllUsers() {

        List<User> users = userRepository.findAll();
        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","Users retrieved successfully",
                "data",users
        );

    }

    // Get User by ID
    public Map<String, Object> getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","UserById retrieved successfully",
                "data",user
        );
    }

    // Get User by Email
    public Map<String, Object> getUserByEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","getUserByEmail retrieved successfully",
                "data",user
        );
    }


    public Map<String, Object> getUserByPhone(String phone) {
        User user = userRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return Map.of(
                "status",HttpStatus.FOUND.value(),
                "success","getUserByPhone retrieved successfully",
                "data",user
        );
    }
}
