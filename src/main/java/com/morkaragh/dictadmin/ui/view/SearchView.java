package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.ui.MainUI;
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

@PermitAll
@Route(value="", layout = MainUI.class)
@PageTitle("Поиск")
public class SearchView extends HorizontalLayout {
    private final TextField login;
    private Button searchBtn;

    public SearchView() {
        login = new TextField("Логин");
        searchBtn = new Button("Поиск правила");
        searchBtn.addClickListener(getSearchClickListener());
        searchBtn.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, login, searchBtn);

        add(login, searchBtn);
    }

    private ComponentEventListener<ClickEvent<Button>> getSearchClickListener() {
        return e -> {
            Notification.show("Для логина: " + login.getValue() + " правило : ");
        };
    }
}
