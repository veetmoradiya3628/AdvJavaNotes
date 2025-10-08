package com.example.spring_boot_demo.controller;

import com.example.spring_boot_demo.config.CustomMetrics;
import com.example.spring_boot_demo.entity.User;
import com.example.spring_boot_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final CustomMetrics customMetrics;

    public UserController(UserService userService, CustomMetrics customMetrics) {
        this.userService = userService;
        this.customMetrics = customMetrics;
    }


    @GetMapping
    public List<User> getAllUsers() {
        customMetrics.incrementGetUserCalls();
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted with id " + id;
    }
}
