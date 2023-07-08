package com.morkaragh.dictadmin.ui.components;

import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.dictionaries.ProgramsDictionary;
import com.morkaragh.dictadmin.rules.KeyValueRule;
import com.morkaragh.dictadmin.rules.KeyValueRuleService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class Table extends VerticalLayout {

    private final ProgramsDictionary programsDict;
    private final KeyValueRuleService ruleService;

    public Table(ProgramsDictionary programsDict, KeyValueRuleService ruleService) {
        this.programsDict = programsDict;
        this.ruleService = ruleService;
    }

    public void displayAgents(List<Agent> agents) {
        removeAll();
        for (Agent agent : agents) {
            KeyValueRule actualRule = ruleService.getActualRule(agent.getId());
            add(new AgentDescription(agent, actualRule, programsDict.getPrograms(),
                    s -> {
                        ruleService.deactivateActualRule(agent.getId());
                        if (s != null) {
                            ruleService.saveNewRule(new KeyValueRule().setKey(agent.getId()).setValue(s));
                        }
                    }));
        }
    }


}
