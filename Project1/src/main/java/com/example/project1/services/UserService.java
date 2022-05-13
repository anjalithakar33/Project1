package com.example.project1.services;

import com.example.project1.models.LoginDTO;
import com.example.project1.models.Users;
import com.example.project1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers(){
        List<Users> users = userRepository.findAll();
        return users;
    }

    public Users login(LoginDTO dto) {
       // Users user = userRepository.findByUserEmailAndPassword(dto.getUserEmail(), dto.getPassword());
        Users user = userRepository.findAllByUserEmail(dto.getUserEmail()).stream()
                .filter(x -> x.getUserEmail().equals(dto.getUserEmail()))
                .collect(Collectors.toList()).get(0);
        return user;
    }
}
