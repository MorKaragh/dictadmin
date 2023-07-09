package com.morkaragh.dictadmin.dictionaries;

import com.morkaragh.dictadmin.dictionaries.internal.AgentsDictionaryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class AgentsDictionaryImplTest {

    @Autowired
    private AgentsDictionaryImpl dictionary;

    @Test
    void getAgents() {
        assertFalse(dictionary.getAgents().isEmpty());
    }
}