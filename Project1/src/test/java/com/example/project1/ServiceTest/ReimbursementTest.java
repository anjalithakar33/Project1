package com.example.project1.ServiceTest;

import com.example.project1.models.*;
import com.example.project1.repositories.ReimbursementRepository;
import com.example.project1.services.ReimbursementService;
import com.ibm.disthub2.impl.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReimbursementTest {
    @Mock
    private ReimbursementRepository reimbursementRepository;

    @InjectMocks
    private ReimbursementService reimbursementService = new ReimbursementService();

    @Test
    public void positive(){
        Reimbursement fakeReimbursement = new Reimbursement(1, Date.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()))
                ,Date.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())),"Test",
                new Users(1,"TestFirstName","TestLasstname","test@test.com","password",
                        "123456789",new UserRole(1,"Employee")),
                new Users(2,"Fname","ManagerLast","test1@test.com","password1",
                        "123487459",new UserRole(2,"Manager")),
                new ReimbStatus(2,"Approved"),new ReimbType(2,"Lodging"));
        List<Reimbursement> reimbursementList = new ArrayList<>();
        reimbursementList.add(fakeReimbursement);
        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);
        List<Reimbursement> actual = reimbursementService.getAllReimbursements();
        Assertions.assertEquals(1,actual.size());
    }
    @Test
    public void negative(){
        List<Reimbursement> reimbursementList = new ArrayList<>();

        when(reimbursementRepository.findAll()).thenReturn(reimbursementList);

        List<Reimbursement> actual = reimbursementService.getAllReimbursements();
        Assertions.assertEquals(0,actual.size());
    }
    @Test
    public void positiveAddNewReimb(){
        Reimbursement fakeReimbursement = new Reimbursement(1, Date.valueOf(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()))
                ,"Test", new Users(1,"TestFirstName","TestLasstname","test@test.com","password",
                        "123456789",new UserRole(1,"Employee")),
                new ReimbStatus(1,"Pending"),new ReimbType(2,"Lodging"));
        lenient().when(reimbursementRepository.save(fakeReimbursement)).thenReturn(fakeReimbursement);
        Reimbursement actual = reimbursementService.addNewReimbursement(fakeReimbursement);
        Assertions.assertEquals(fakeReimbursement,actual);
    }
    @Test
    public void negativeAddReimb(){
        Reimbursement fakeReimb = new Reimbursement();
        when(reimbursementRepository.save(fakeReimb)).thenReturn(fakeReimb);
        Reimbursement actual = reimbursementService.addNewReimbursement(fakeReimb);
        Assertions.assertEquals(fakeReimb,actual);

    }

}
