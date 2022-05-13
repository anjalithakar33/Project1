package com.example.project1.services;

import com.example.project1.exception.ReimbursementNotFound;
import com.example.project1.models.Reimbursement;
import com.example.project1.models.ReimbursementDTO;
import com.example.project1.repositories.ReimbursementRepository;
import com.example.project1.repositories.ReimbursementStatusRepository;
import com.example.project1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class ReimbursementService {

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReimbursementStatusRepository statusRepository;


    public List<Reimbursement> getAllReimbursements() throws ReimbursementNotFound {
        List<Reimbursement> reimbursements = reimbursementRepository.findAll();
        return reimbursements;
    }

    /**
     * @Param
     * @return reimbursement - This is reimbursement model object
     *      */
    public Reimbursement addNewReimbursement(Reimbursement reimbursement) {
        Reimbursement newReimbursement = reimbursementRepository.save(reimbursement);
        return newReimbursement;

    }

    public Reimbursement updateReimbursement(ReimbursementDTO reimbursement) {

        Reimbursement oldReimb = reimbursementRepository.getById(reimbursement.getReimId());
        oldReimb.setReimbApproved(Date.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())));
        oldReimb.setReimbResolver(userRepository.getById(reimbursement.getReimbResolver().getUserId()));
        oldReimb.setStatusId(statusRepository.getById(reimbursement.getReimbStatus().getStatusId()));

        return reimbursementRepository.save(oldReimb);

    }
}
