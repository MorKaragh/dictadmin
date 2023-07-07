package com.morkaragh.dictadmin.rules;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface KeyValueRuleService {

    Optional<KeyValueRule> getActualRule(String key);

    void saveNewRule(Rule rule);

    void deleteRule(Rule rule);

}
