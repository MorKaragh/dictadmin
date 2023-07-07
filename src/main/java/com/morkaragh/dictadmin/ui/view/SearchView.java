package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.dictionaries.AgentsDictionary;
import com.morkaragh.dictadmin.rules.KeyValueRule;
import com.morkaragh.dictadmin.rules.KeyValueRuleService;
import com.morkaragh.dictadmin.ui.MainUI;
import com.morkaragh.dictadmin.ui.components.RulePanel;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PermitAll
@Route(value="search", layout = MainUI.class)
@PageTitle("Поиск")
public class SearchView extends HorizontalLayout {
    private final AgentsDictionary dictionary;
    private final TextField nameFld;
    private final TextField agentContractFld;
    private final RulePanel rulePanel;

    public SearchView(AgentsDictionary dictionary) {
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
            if (CollectionUtils.isEmpty(agentList)) {
                Notification.show("Не найдено значение", 3000, Notification.Position.MIDDLE);
            } else {
                Notification.show("Найдено: " + agentList.size(), 3000, Notification.Position.MIDDLE);

            }
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
