package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.ui.MainUI;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Таблица")
@Route(value = "table", layout = MainUI.class)
public class TableView extends HorizontalLayout {
    private TextField name;
    private Button sayHello;

    public TableView() {
        name = new TextField("Логин");
        sayHello = new Button("Искать");
        sayHello.addClickListener(e -> {
            Notification.show("Найден по логину: " + name.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);

    }

}
