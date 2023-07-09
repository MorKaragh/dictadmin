package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.MainUI;
import com.morkaragh.dictadmin.dictionaries.Agent;
import com.morkaragh.dictadmin.dictionaries.Program;
import com.morkaragh.dictadmin.dictionaries.ProgramsDictionary;
import com.morkaragh.dictadmin.dictionaries.internal.AgentsDictionaryImpl;
import com.morkaragh.dictadmin.rules.FixedProgramForAgent;
import com.morkaragh.dictadmin.rules.FixedProgramForAgentService;
import com.morkaragh.dictadmin.ui.components.LockButtonSelector;
import com.morkaragh.dictadmin.ui.components.SearchField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.util.CollectionUtils;

@PermitAll
@PageTitle("Назначение обязательных программ NBO")
@Route(value = "", layout = MainUI.class)
public class TableView extends VerticalLayout {

    private final FixedProgramForAgentService service;
    private final ProgramsDictionary programsDictionary;
    private final Grid<Agent> grid;

    public TableView(FixedProgramForAgentService service, AgentsDictionaryImpl agentsDictionary, ProgramsDictionary programsDictionary) {
        setSpacing(true);
        this.service = service;
        this.programsDictionary = programsDictionary;

        grid = new Grid<>(Agent.class, false);
        grid.setVisible(false);
        grid.addColumn(Agent::getId).setHeader("Логин").setWidth("0.1em").setFlexGrow(1);
        grid.addColumn(Agent::getName).setHeader("ФИО").setWidth("1em").setFlexGrow(2);
        grid.addColumn(Agent::getDescription).setHeader("Доп.инфо.").setWidth("1em").setFlexGrow(2);
        grid.addComponentColumn(s -> {
            FixedProgramForAgent actual = service.getActualFixedProgramForAgent(s.getId());
            return new LockButtonSelector("Выберите фиксированную программу"
                    , programsDictionary.getPrograms().stream().map(Program::getName).toList()
                    , actual != null ? actual.getValue() : null,
                    newVal -> {
                        service.deactivateFixedProgramForAgent(s.getId());
                        if (newVal != null) {
                            service.saveNewFixedProgramForAgent(new FixedProgramForAgent().setKey(s.getId()).setValue(newVal));
                        }
                    });
        }).setAutoWidth(true).setFlexGrow(2);

        SearchField searchField = new SearchField(agentsDictionary, agents -> {
            if (!CollectionUtils.isEmpty(agents)) {
                grid.setVisible(true);
                grid.setItems(agents);
            } else {
                grid.setVisible(false);
            }
        });

        add(searchField, grid);
    }

}
