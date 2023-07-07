package com.morkaragh.dictadmin.dictionaries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AgentsDictionaryTest {

    @Autowired
    private AgentsDictionary dictionary;

    @Test
    void getAgents() {
        assertFalse(dictionary.getAgents().isEmpty());
    }
}