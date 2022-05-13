package com.example.project1.controllers;

import com.example.project1.models.Reimbursement;
import com.example.project1.models.ReimbursementDTO;
import com.example.project1.services.ReimbursementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ReimbursementService reimbursementService;

    /**
     * Get All Reimburssement
     * @return all reimbursements
     */
    @GetMapping
    public ResponseEntity<?> getAllReimbursements(){

        logger.info("getAllReimbursement endpoint invoked");

        List<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
        return ResponseEntity.ok().body(reimbursements);
    }

    /**
     *
     * @param reimbursement -This is a reimbursement model object
     * @return - This will return a reimbursement object
     */
    @PostMapping()
    public ResponseEntity<?> addReimbursement(@RequestBody Reimbursement reimbursement) {

        logger.info("addReimbursement endpoint invoked");

        Reimbursement reimbursements= reimbursementService.addNewReimbursement(reimbursement);

        return ResponseEntity.ok().body(reimbursements);
    }

    @PutMapping()
    public ResponseEntity<?> updateReimbursement(@RequestBody ReimbursementDTO reimbursement){
        Reimbursement updaedReimbursement = reimbursementService.updateReimbursement(reimbursement);
        return ResponseEntity.ok().body(updaedReimbursement);
    }
}
