package com.example.project1.repositories;

import com.example.project1.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findAllByUserEmail (String email);
    public abstract Users findByUserEmailAndPassword(String userEmail, String password);
}
