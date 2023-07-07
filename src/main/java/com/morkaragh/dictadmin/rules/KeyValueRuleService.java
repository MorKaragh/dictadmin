package com.morkaragh.dictadmin.rules;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface KeyValueRuleService {

    List<KeyValueRule> getActualRule(String key);

    void saveNewRule(KeyValueRule rule);

    void deleteRule(KeyValueRule rule);

}
