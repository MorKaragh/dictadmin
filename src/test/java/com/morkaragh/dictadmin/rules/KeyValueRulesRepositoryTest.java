package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

@SpringBootTest
@Testcontainers
class KeyValueRulesRepositoryTest {

    private static final String POSTGRES_IMAGE = "postgres:latest";
    private static final String POSTGRES_DB = "assignment-test";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "postgrespass";

    @Autowired
    KeyValueRulesRepository keyValueRulesRepository;


    @Test
    public void testSaveAndLoad() {
        LocalDate now = LocalDate.now();
        keyValueRulesRepository.save((KeyValueRule) new KeyValueRule()
                .setKey("hello")
                .setValue("world")
                .setInsertDate(now)
                .setStartDate(now)
                .setCreatedBy(new User()));



    }

}