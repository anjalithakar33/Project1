package com.example.project1.controllers;

import com.example.project1.models.LoginDTO;
import com.example.project1.models.Users;
import com.example.project1.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getAllUser(){
        logger.info("getAllUsers endpoin invoked");
        List<Users> usersList = userService.getAllUsers();
        return ResponseEntity.ok().body(usersList);

    }

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginDTO dto){
        logger.info("Login endpoin invoked");
        LoginDTO loginInfo = dto;
        Users users = userService.login(dto);
        return ResponseEntity.ok().body(users);

    }
}
