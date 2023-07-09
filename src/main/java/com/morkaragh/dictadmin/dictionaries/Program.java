package com.morkaragh.dictadmin.dictionaries;

import jakarta.validation.constraints.NotNull;

public class Program {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public Program setName(String name) {
        this.name = name;
        return this;
    }
}
