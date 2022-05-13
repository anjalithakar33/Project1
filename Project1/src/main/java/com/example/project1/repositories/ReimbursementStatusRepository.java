package com.example.project1.repositories;

import com.example.project1.models.ReimbStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementStatusRepository extends JpaRepository<ReimbStatus, Integer> {
}
