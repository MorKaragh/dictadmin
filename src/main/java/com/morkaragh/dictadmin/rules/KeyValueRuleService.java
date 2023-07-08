package com.morkaragh.dictadmin.rules;

import org.springframework.stereotype.Service;

@Service
public interface KeyValueRuleService {

    KeyValueRule getActualRule(String key);

    KeyValueRule saveNewRule(KeyValueRule rule);

    void deactivateActualRule(String agentId);

}
