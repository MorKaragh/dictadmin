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

    public String getKey() {
        return key;
    }

    public KeyValueRule setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public KeyValueRule setValue(String value) {
        this.value = value;
        return this;
    }
}
