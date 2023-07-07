package com.morkaragh.dictadmin.ui.components;

import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.rules.KeyValueRule;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class RulePanel extends HorizontalLayout {
    private final H2 header;
    private NativeLabel agentName = new NativeLabel();
    private NativeLabel agentDescription = new NativeLabel();
    private NativeLabel value = new NativeLabel();

    public RulePanel() {
        header = new H2("Правило");
        this.add(header, agentName, agentDescription, value);
    }

    public void init(Agent agent, KeyValueRule keyValueRule){
        agentName.setText(agent.getName());
        agentDescription.setText(agent.getDescription());
        value.setText(keyValueRule.getValue());
    }
}
