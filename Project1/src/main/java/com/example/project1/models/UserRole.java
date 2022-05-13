package com.example.project1.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userRoleId")
    private int userRoleid;

    @Column(name = "userRole")
    private String userRole;
}
