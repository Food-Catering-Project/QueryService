package com.example.QueryService.Controller;

import com.example.QueryService.Entity.User;
import com.example.QueryService.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        try {
            Map<String, Object> response = userService.getAllUsers();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "Unable to fetch users", "error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // Get User by ID
    @GetMapping("/getSolo/{userId}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long userId) {
        try {
            Map<String, Object> response = userService.getUserById(userId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "User not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    //userBY PHONE
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Map<String, Object>> getUserByPhone(@PathVariable String phone) {
        try {
            Map<String, Object> response = userService.getUserByPhone(phone);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "User not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }



    // Get User by Email
    @GetMapping("/getByEmail/email")
    public ResponseEntity<Map<String, Object>> getUserByEmail(@RequestParam String email) {
        try {
            Map<String, Object> response = userService.getUserByEmail(email);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", "User not found", "error", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


}
