package com.example.project1.models;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LoginDTO {
    private String userEmail;
    private String password;


}
