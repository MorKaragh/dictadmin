package com.morkaragh.dictadmin.ui.components;

import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.programfixation.FixedProgramForAgent;
import com.morkaragh.dictadmin.ui.common.Label;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.List;
import java.util.function.Consumer;

public class AgentDescription extends HorizontalLayout {

    public AgentDescription(Agent agent, FixedProgramForAgent rule, List<String> variants, Consumer<String> onSave) {
        getStyle().set("color", "LightGray")
                .set("border-radius", "2em");

        Div idLabel = Label.varSize(agent.getId(), "1.5em", "150px");
        Div nameLabel = Label.varSize(agent.getName(), "1.2em", "400px");
        Div descLabel = Label.varSize(agent.getDescription(), "1em", "300px");
        descLabel.getStyle().set("padding-top", "5px");
        setSpacing(true);
        add(idLabel, nameLabel, descLabel);

        add(new LockButtonSelector("Выберите обязательную программу",
                variants, rule != null ? rule.getValue() : null,
                onSave));

    }


}
