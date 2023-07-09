package com.morkaragh.dictadmin.dictionaries.internal;

import com.morkaragh.dictadmin.dictionaries.Program;
import com.morkaragh.dictadmin.dictionaries.ProgramsDictionary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramsDictionaryImp implements ProgramsDictionary {

    @Override
    public List<Program> getPrograms() {
        return List.of(
                new Program().setName("Каско в 10"),
                new Program().setName("Каско дай 5"),
                new Program().setName("Каско за 3"));
    }

}
