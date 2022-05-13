package com.example.project1.controllers;

import com.example.project1.services.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    SendEmail sendEmail;

    @RequestMapping(value = "/sendEmail")
    public String sendEmail() throws MessagingException, IOException {
        String email = sendEmail.sendmail();
        return email;
    }
}
