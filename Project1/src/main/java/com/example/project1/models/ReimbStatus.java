package com.example.project1.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reimbStatus")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReimbStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId")
    private int statusId;

    @Column(name = "status")
    private String status;

    public ReimbStatus(String status) {
        this.status = status;
    }

    public ReimbStatus(int statusId) {
        this.statusId = statusId;
    }
}
