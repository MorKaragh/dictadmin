package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.dictionaries.AgentsDictionary;
import com.morkaragh.dictadmin.dictionaries.ProgramsDictionary;
import com.morkaragh.dictadmin.rules.KeyValueRuleService;
import com.morkaragh.dictadmin.ui.MainUI;
import com.morkaragh.dictadmin.ui.components.SearchField;
import com.morkaragh.dictadmin.ui.components.Table;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Таблица")
@Route(value = "table", layout = MainUI.class)
public class TableView extends VerticalLayout {

    private SearchField searchField;
    private Table table;

    public TableView(KeyValueRuleService service, AgentsDictionary agentsDictionary, ProgramsDictionary programsDictionary) {
        setSpacing(true);
        searchField = new SearchField(agentsDictionary, agents -> table.displayAgents(agents));
        table = new Table(programsDictionary, service);
        add(searchField, table);
    }
}
