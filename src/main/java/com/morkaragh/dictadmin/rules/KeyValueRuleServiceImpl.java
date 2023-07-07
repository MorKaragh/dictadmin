package com.morkaragh.dictadmin.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class KeyValueRuleServiceImpl implements KeyValueRuleService{

    @Autowired
    private KeyValueRulesRepository repository;

    @Override
    public List<KeyValueRule> getActualRule(String key) {
        return repository.findByEndDateNullAndKey(key);
    }

    @Override
    public KeyValueRule saveNewRule(KeyValueRule rule) {
        rule.setInsertDate(LocalDate.now());
        return repository.save(rule);
    }

    @Override
    public KeyValueRule deleteRule(KeyValueRule rule) {
        rule.setEndDate(LocalDate.now());
        return repository.save(rule);
    }
}
