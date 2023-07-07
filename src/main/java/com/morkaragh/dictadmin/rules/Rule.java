package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Rule {

    @Id
    private Long id;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    private User createdBy;

}
