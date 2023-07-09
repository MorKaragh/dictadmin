package com.morkaragh.dictadmin.programfixation;


import com.morkaragh.dictadmin.programfixation.internal.Rule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class FixedProgramForAgent extends Rule {

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    public String getKey() {
        return key;
    }

    public FixedProgramForAgent setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public FixedProgramForAgent setValue(String value) {
        this.value = value;
        return this;
    }
}
