package com.morkaragh.dictadmin.programfixation.internal;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rules")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "insert_date")
    private LocalDateTime insertDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "created_by")
    private String createdBy;

    public Long getId() {
        return id;
    }

    public Rule setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public Rule setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Rule setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Rule setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Rule setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
