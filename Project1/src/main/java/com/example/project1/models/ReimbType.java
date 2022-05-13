package com.example.project1.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reimbType")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReimbType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimbTypeId")
    private int reimbTypeId;

    @Column(name = "reimbType")
    private String reimbType;
}
