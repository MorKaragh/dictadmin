package com.morkaragh.dictadmin.programfixation.internal;

import com.morkaragh.dictadmin.programfixation.FixedProgramForAgent;
import com.morkaragh.dictadmin.programfixation.FixedProgramForAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FixedProgramForAgentServiceImpl implements FixedProgramForAgentService {

    @Autowired
    private KeyValueRulesRepository repository;

    @Override
    public FixedProgramForAgent getActualFixedProgramForAgent(String key) {
        return repository.findByEndDateNullAndKey(key);
    }

    @Override
    public void saveNewFixedProgramForAgent(FixedProgramForAgent rule) {
        rule.setInsertDate(LocalDateTime.now());
        if (rule.getStartDate() == null || rule.getStartDate().isBefore(LocalDateTime.now())) {
            rule.setStartDate(LocalDateTime.now());
        }
        repository.save(rule);
    }

    @Override
    public void deactivateFixedProgramForAgent(String agentId) {
        FixedProgramForAgent byEndDateNullAndKey = repository.findByEndDateNullAndKey(agentId);
        if (byEndDateNullAndKey != null) {
            byEndDateNullAndKey.setEndDate(LocalDateTime.now());
            repository.save(byEndDateNullAndKey);
        }
    }
}
