package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.rules.internal.KeyValueRulesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KeyValueRuleServiceImpl implements KeyValueRuleService {

    @Autowired
    private KeyValueRulesRepository repository;

    @Override
    public KeyValueRule getActualRule(String key) {
        return repository.findByEndDateNullAndKey(key);
    }

    @Override
    public KeyValueRule saveNewRule(KeyValueRule rule) {
        rule.setInsertDate(LocalDateTime.now());
        if (rule.getStartDate() == null || rule.getStartDate().isBefore(LocalDateTime.now())) {
            rule.setStartDate(LocalDateTime.now());
        }
        return repository.save(rule);
    }

    @Override
    public void deactivateActualRule(String agentId) {
        KeyValueRule byEndDateNullAndKey = repository.findByEndDateNullAndKey(agentId);
        if (byEndDateNullAndKey != null) {
            byEndDateNullAndKey.setEndDate(LocalDateTime.now());
            repository.save(byEndDateNullAndKey);
        }
    }
}
