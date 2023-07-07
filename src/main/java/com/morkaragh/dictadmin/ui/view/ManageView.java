package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.ui.MainUI;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;


@PermitAll
@Route(value="", layout = MainUI.class)
@PageTitle("Управление правилами")
public class ManageView extends HorizontalLayout {
    private final TextField login;
    private final TextField fioFld;
    private final TextField keyFld;
    private final TextField valueFld;
    private Button searchBtn;

    public ManageView() {
        this.fioFld = new TextField("ФИО");
        this.login = new TextField("Логин");
        NativeLabel label = new  NativeLabel("Правило");
        this.keyFld = new TextField("Ключ");
        this.valueFld = new TextField("Значение");
        this.searchBtn = new Button("Добавить правило");
        this.searchBtn.addClickListener(getSearchClickListener());
        this.searchBtn.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, login, searchBtn);

        add(label,login);
        add(keyFld, valueFld, searchBtn);
    }

    private ComponentEventListener<ClickEvent<Button>> getSearchClickListener() {
        return e -> {
            Notification.show("Для логина: " + login.getValue() + " правило : ");
        };
    }
}
