package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.rules.internal.KeyValueRulesRepository;
import com.morkaragh.dictadmin.user.User;
import com.morkaragh.dictadmin.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class KeyValueRulesRepositoryTest {


    @Autowired
    KeyValueRulesRepository keyValueRulesRepository;

    @Autowired
    UserRepository userRepository;

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


    private final String hello = "hello";
    private final String world = "world";


    @Test
    @Transactional
    public void testSaveAndLoad() {
        LocalDateTime now = LocalDateTime.now();

        User user = userRepository.save(new User().setLogin("ADMIN").setFullName("АДМИН АДМИНЫЧ"));


        keyValueRulesRepository.save((KeyValueRule) new KeyValueRule()
                .setKey(hello)
                .setValue(world)
                .setInsertDate(now)
                .setStartDate(now)
                .setCreatedBy(user));

        Optional<KeyValueRule> rule = keyValueRulesRepository.findByCreatedBy_LoginIgnoreCase("ADMIN");
        assertTrue(rule.isPresent());
        assertEquals(hello, rule.get().getKey());
        assertEquals(world, rule.get().getValue());
    }

    @Test
    @Transactional
    public void testFindByKey() {
        keyValueRulesRepository.save((KeyValueRule) new KeyValueRule().setKey(hello).setValue(world).setInsertDate(LocalDateTime.now()));
        KeyValueRule byEndDateNullAndKey = keyValueRulesRepository.findByEndDateNullAndKey(hello);
        assertNotNull(byEndDateNullAndKey);
    }

    @Test
    @Transactional
    public void testFindAll() {
        keyValueRulesRepository.save((KeyValueRule) new KeyValueRule()
                .setKey(hello).setValue(world).setInsertDate(LocalDateTime.now()));
        KeyValueRule byEndDateNullAndKey = keyValueRulesRepository.findByEndDateNullAndKey(hello);
        assertNotNull(byEndDateNullAndKey);
    }

}