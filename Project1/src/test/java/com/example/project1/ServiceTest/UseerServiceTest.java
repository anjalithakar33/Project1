package com.example.project1.ServiceTest;


import com.example.project1.models.LoginDTO;
import com.example.project1.models.UserRole;
import com.example.project1.models.Users;
import com.example.project1.repositories.UserRepository;
import com.example.project1.services.UserService;
import org.apache.catalina.LifecycleState;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UseerServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService= new UserService();

    @Test
    public void positiveGetAll(){
        Users user1 =   new Users(1,"TestFirstName","TestLasstname","test@test.com","password",
                "123456789",new UserRole(1,"Employee"));
        Users user2 = new Users(2,"Fname","ManagerLast","test1@test.com","password1",
                "123487459",new UserRole(2,"Manager"));
        List<Users> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        when(userRepository.findAll()).thenReturn(usersList);
        List<Users> actual = userService.getAllUsers();
        Assertions.assertEquals(usersList,actual);

    }
    @Test
    public void negativeGetAll(){

        List<Users> usersList = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(usersList);
        List<Users> actual = userService.getAllUsers();
        Assertions.assertEquals(usersList,actual);

    }

    @Test
    public void loginPositive(){
        LoginDTO dto =new LoginDTO("email","password");
        Users user = new Users(1,"TestFirstName","TestLasstname","email","password",
                "123456789",new UserRole(1,"Employee"));
        when(userRepository.findAllByUserEmail(dto.getUserEmail())).thenReturn(Collections.singletonList(user));
        Users actual = userService.login(dto);
        Assertions.assertEquals(user,actual);

    }

}
