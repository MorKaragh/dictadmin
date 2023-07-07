package com.morkaragh.dictadmin.rules;

import com.morkaragh.dictadmin.rules.internal.KeyValueRulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        if (rule.getStartDate() == null || rule.getStartDate().isBefore(LocalDate.now())) {
            rule.setStartDate(LocalDate.now());
        }
        return repository.save(rule);
    }

    @Override
    public KeyValueRule deleteRule(KeyValueRule rule) {
        rule.setEndDate(LocalDate.now());
        return repository.save(rule);
    }
}
