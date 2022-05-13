package com.example.project1.models;

import com.example.project1.models.ReimbStatus;
import com.example.project1.models.Users;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReimbursementDTO {
    private int reimId;
    private Users reimbResolver;
    private ReimbStatus reimbStatus;


}
