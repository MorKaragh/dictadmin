package com.morkaragh.dictadmin.ui.components;

import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.dictionaries.internal.AgentsDictionaryImpl;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SearchField extends HorizontalLayout {
    private final AgentsDictionaryImpl dictionary;
    private final TextField nameFld;
    private final TextField agentContractFld;
    private final RulePanel rulePanel;
    private final Consumer<List<Agent>> onSelect;

    public SearchField(AgentsDictionaryImpl dictionary, Consumer<List<Agent>> onSelect) {
        this.onSelect = onSelect;
        this.dictionary = dictionary;
        this.nameFld = new TextField("Имя агента");
        this.agentContractFld = new TextField("Агентский договор");
        Button searchBtn = new Button("Поиск правила");
        searchBtn.addClickListener(getSearchClickListener());
        searchBtn.addClickShortcut(Key.ENTER);
        rulePanel = new RulePanel();
        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, nameFld, agentContractFld, searchBtn);

        add(nameFld, searchBtn);
    }

    private ComponentEventListener<ClickEvent<Button>> getSearchClickListener() {
        return e -> {
            List<Agent> agentList = search(nameFld.getValue(), agentContractFld.getValue());
            onSelect.accept(agentList);
        };
    }

    private List<Agent> search(String name, String agentContract) {
        List<Agent> agents = dictionary.getAgents();
        return agents.stream()
                .filter(agent -> StringUtils.containsIgnoreCase(agent.getName(), name))
                .filter(agent -> StringUtils.containsIgnoreCase(agent.getDescription(), agentContract))
                .collect(Collectors.toList());
    }
}
