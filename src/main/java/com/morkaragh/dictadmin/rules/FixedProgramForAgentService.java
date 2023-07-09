package com.morkaragh.dictadmin.rules;

import org.springframework.stereotype.Service;

@Service
public interface FixedProgramForAgentService {

    FixedProgramForAgent getActualFixedProgramForAgent(String key);

    void saveNewFixedProgramForAgent(FixedProgramForAgent rule);

    void deactivateFixedProgramForAgent(String agentId);

}
