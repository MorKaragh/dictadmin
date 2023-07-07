package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "rules")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    private User createdBy;

    public Long getId() {
        return id;
    }

    public Rule setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public Rule setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Rule setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Rule setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Rule setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
