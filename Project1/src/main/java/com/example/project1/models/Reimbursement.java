package com.example.project1.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "reimbursement")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimbId")
    private int reimbId;

    @Column(name = "reimbAmount")
    private int reimbAmount;

    @Column(name = "reimbSubmitted")
    private Date reimbSubmitted;

    @Column(name = "reimbApproved")
    private Date reimbApproved;

    @Column(name = "reimbDescription")
    private String reimbDescription;

    @ManyToOne
    @JoinColumn(name = "reimbAuthor")
    private Users reimbAuthor;

    @ManyToOne
    @JoinColumn(name = "reimbResolver")
    private Users reimbResolver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId")
    private ReimbStatus statusId;

    @ManyToOne
    @JoinColumn(name = "reimbTypeId")
    private ReimbType reimbTypeId;

    public Reimbursement(int reimbAmount, Date reimbSubmitted, Date reimbApproved, String reimbDescription, Users reimbAuthor, Users reimbResolver, ReimbStatus statusId, ReimbType reimbTypeId) {
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbApproved = reimbApproved;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.statusId = statusId;
        this.reimbTypeId = reimbTypeId;
    }

    public Reimbursement(int reimbAmount, Date reimbSubmitted, String reimbDescription, Users reimbAuthor, ReimbStatus statusId, ReimbType reimbTypeId) {
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.statusId = statusId;
        this.reimbTypeId = reimbTypeId;
    }

    public Reimbursement(int reimbId, Date reimbApproved, Users reimbResolver, ReimbStatus statusId) {
        this.reimbId = reimbId;
        this.reimbApproved = reimbApproved;
        this.reimbResolver = reimbResolver;
        this.statusId = statusId;
    }
}
