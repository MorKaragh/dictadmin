package com.morkaragh.dictadmin.dictionaries;

public class Agent {

    private Long id;
    private String name;
    private String description;


    public Agent(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Agent setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Agent setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Agent setDescription(String description) {
        this.description = description;
        return this;
    }
}
