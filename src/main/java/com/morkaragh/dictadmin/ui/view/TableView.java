package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.MainUI;
import com.morkaragh.dictadmin.dictionaries.internal.AgentsDictionaryImpl;
import com.morkaragh.dictadmin.dictionaries.internal.ProgramsDictionaryImp;
import com.morkaragh.dictadmin.rules.FixedProgramForAgentService;
import com.morkaragh.dictadmin.ui.components.SearchField;
import com.morkaragh.dictadmin.ui.components.Table;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Таблица")
@Route(value = "", layout = MainUI.class)
public class TableView extends VerticalLayout {

    public TableView(FixedProgramForAgentService service, AgentsDictionaryImpl agentsDictionary, ProgramsDictionaryImp programsDictionaryImp) {
        setSpacing(true);
        Table table = new Table(programsDictionaryImp, service);
        SearchField searchField = new SearchField(agentsDictionary, table::displayAgents);
        add(searchField, table);
    }
}
