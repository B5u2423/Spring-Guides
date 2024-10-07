package com.demo.accessmysql.controller;

import com.demo.accessmysql.entity.User;
import com.demo.accessmysql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class MainController {
    private final UserRepository userRepository;

    @PostMapping(path = "/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);

        return "Save to Database...";
    }

    @GetMapping(path = "/get")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
