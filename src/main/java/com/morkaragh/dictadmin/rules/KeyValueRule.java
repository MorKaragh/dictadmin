package com.morkaragh.dictadmin.rules;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "keyvalue_rules")
public class KeyValueRule extends Rule {

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

}
