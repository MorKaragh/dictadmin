package com.morkaragh.dictadmin.agent;

import com.morkaragh.dictadmin.ui.common.Label;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.Consumer;

public class LockButtonSelector extends HorizontalLayout {

    private Button editBtn;
    private Button openButton;
    private Button saveButton;
    private Button cancelButton;
    private Button removeBtn;
    private Select<String> selected;


    public LockButtonSelector(String caption, List<String> variants, String value, Consumer<String> onSave) {
        openButton = new Button(caption, new Icon(VaadinIcon.SAFE_LOCK));
        openButton.addClickListener(e -> setUnlocked());

        selected = new Select<>();
        selected.setWidth("200px");
        selected.setValue(value);
        selected.setItems(variants);
        selected.addValueChangeListener(new HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<Select<String>, String>>() {
            @Override
            public void valueChanged(AbstractField.ComponentValueChangeEvent<Select<String>, String> event) {
                saveButton.setVisible(StringUtils.isNotBlank(event.getValue()));
            }
        });

        saveButton = new Button("Сохранить", new Icon(VaadinIcon.INBOX));
        saveButton.setVisible(false);
        saveButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                onSave.accept(selected.getValue());
                setLocked();
            }
        });
        saveButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SUCCESS);

        cancelButton = new Button(new Icon(VaadinIcon.CLOSE_BIG));
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
        cancelButton.addClickListener(e -> setLocked());

        removeBtn = new Button("Удалить", new Icon(VaadinIcon.BAN));
        removeBtn.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
        removeBtn.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                onSave.accept(null);
                selected.setValue(null);
                setLocked();
            }
        });

        editBtn = new Button("Редактировать");
        editBtn.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);
        editBtn.addClickListener(event -> setUnlocked());

        if (StringUtils.isNotBlank(value)) {
            selected.setValue(value);
        }
        setLocked();
    }


    private void setUnlocked() {
        removeAll();
        add(selected);
        selected.setReadOnly(false);
        add(saveButton);
        add(cancelButton);
    }

    private void setLocked() {
        removeAll();
        if (StringUtils.isNotBlank(selected.getValue())) {
            selected.setReadOnly(true);
            add(selected);
            add(editBtn);
            add(removeBtn);
        } else {
            add(openButton);
        }
    }


}
