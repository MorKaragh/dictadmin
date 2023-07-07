package com.morkaragh.dictadmin.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "full_name")
    private String fullName;

}
