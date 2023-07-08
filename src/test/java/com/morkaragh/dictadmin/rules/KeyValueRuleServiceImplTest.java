package com.morkaragh.dictadmin.rules;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class KeyValueRuleServiceImplTest {

    @SuppressWarnings("rawtypes")
    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("dictadmin")
            .withUsername("ss")
            .withPassword("pa!");

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    }

    @Autowired
    KeyValueRuleService service;

    @Test
    void getActualRule() {
        service.saveNewRule(new KeyValueRule().setValue("value").setKey("key"));
        KeyValueRule keys = service.getActualRule("key");
        assertNotNull(keys);
    }

    @Test
    void saveNewRule() {
    }

    @Test
    void deleteRule() {
    }
}