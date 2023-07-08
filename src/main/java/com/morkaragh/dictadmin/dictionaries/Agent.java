package com.morkaragh.dictadmin.dictionaries;

public class Agent {

    private String id;
    private String name;
    private String description;


    public Agent(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public Agent setId(String id) {
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
