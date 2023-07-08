package com.morkaragh.dictadmin.dictionaries;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramsDictionary {

    public List<String> getPrograms() {
        return List.of("Каско в 10", "Каско дай 5", "Каско за 3");
    }

}
