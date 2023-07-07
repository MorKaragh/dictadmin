package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.user.User;
import com.morkaragh.dictadmin.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class KeyValueRulesRepositoryTest {

    @Autowired
    KeyValueRulesRepository keyValueRulesRepository;

    @Autowired
    UserRepository userRepository;

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
    @Test
    @Transactional
    public void testSaveAndLoad() {
        LocalDate now = LocalDate.now();

        User user = userRepository.save(new User().setLogin("ADMIN").setFullName("АДМИН АДМИНЫЧ"));

        keyValueRulesRepository.save((KeyValueRule) new KeyValueRule()
                .setKey("hello")
                .setValue("world")
                .setInsertDate(now)
                .setStartDate(now)
                .setCreatedBy(user));

        assertTrue(keyValueRulesRepository.findByCreatedBy_LoginIgnoreCase("ADMIN").isPresent());

    }

}