package com.morkaragh.dictadmin.ui.components;

import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.dictionaries.Program;
import com.morkaragh.dictadmin.dictionaries.ProgramsDictionary;
import com.morkaragh.dictadmin.programfixation.FixedProgramForAgent;
import com.morkaragh.dictadmin.programfixation.FixedProgramForAgentService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class Table extends VerticalLayout {

    private final ProgramsDictionary programsDict;
    private final FixedProgramForAgentService fixedProgramForAgentService;


    public Table(ProgramsDictionary programsDict, FixedProgramForAgentService fixedProgramForAgentService) {
        this.programsDict = programsDict;
        this.fixedProgramForAgentService = fixedProgramForAgentService;
    }

    public void displayAgents(List<Agent> agents) {
        removeAll();
        for (Agent agent : agents) {
            FixedProgramForAgent actualRule = fixedProgramForAgentService.getActualFixedProgramForAgent(agent.getId());
            add(new AgentDescription(agent,
                    actualRule,
                    programsDict.getPrograms().stream().map(Program::getName).toList(),
                    s -> {
                        fixedProgramForAgentService.deactivateFixedProgramForAgent(agent.getId());
                        if (s != null) {
                            fixedProgramForAgentService.saveNewFixedProgramForAgent(new FixedProgramForAgent().setKey(agent.getId()).setValue(s));
                        }
                    }));
        }
    }


}
