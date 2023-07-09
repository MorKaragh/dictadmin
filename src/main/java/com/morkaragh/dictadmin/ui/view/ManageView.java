package com.morkaragh.dictadmin.ui.view;


import com.morkaragh.dictadmin.MainUI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.core.context.SecurityContextHolder;


@PermitAll
@Route(value = "/admin", layout = MainUI.class)
@PageTitle("Управление")
public class ManageView extends HorizontalLayout {

    Button button = new Button("Посмотреть юзера");

    public ManageView() {
        button.addClickListener(
                e -> {
                    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    System.out.println(principal);
                }
        );
        add(button);
    }
}
