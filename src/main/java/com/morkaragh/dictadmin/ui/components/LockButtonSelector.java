package com.morkaragh.dictadmin.ui.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

    private String initialValue;

    public LockButtonSelector(String caption, List<String> variants, String value, Consumer<String> onSave) {
        this.initialValue = value;
        createOpenButton(caption);
        createSelect(variants, value);
        createSaveButton(onSave);
        createCancelButton();
        createRemoveButton(onSave);
        createEditButton(value);
    }

    private void createEditButton(String value) {
        editBtn = new Button("Редактировать");
        editBtn.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_TERTIARY);
        editBtn.addClickListener(event -> setUnlockedState());

        if (StringUtils.isNotBlank(value)) {
            selected.setValue(value);
        }
        setLockedState();
    }

    private void createRemoveButton(Consumer<String> onSave) {
        removeBtn = new Button("Удалить", new Icon(VaadinIcon.BAN));
        removeBtn.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);
        removeBtn.addClickListener(event -> {
            onSave.accept(null);
            selected.setValue(null);
            setLockedState();
        });
    }

    private void createOpenButton(String caption) {
        openButton = new Button(caption, new Icon(VaadinIcon.SAFE_LOCK));
        openButton.addClickListener(e -> setUnlockedState());
    }

    private void createSelect(List<String> variants, String value) {
        selected = new Select<>();
        selected.setWidth("200px");
        selected.setValue(value);
        selected.setItems(variants);
        selected.addValueChangeListener(event -> saveButton.setVisible(StringUtils.isNotBlank(event.getValue())));
    }

    private void createSaveButton(Consumer<String> onSave) {
        saveButton = new Button("Сохранить", new Icon(VaadinIcon.INBOX));
        saveButton.setVisible(false);
        saveButton.addClickListener(event -> {
            onSave.accept(selected.getValue());
            setLockedState();
        });
        saveButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_ERROR);
    }

    private void createCancelButton() {
        cancelButton = new Button("Отмена",new Icon(VaadinIcon.CLOSE_BIG));
        cancelButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);
        cancelButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                selected.setValue(initialValue);
                setLockedState();
            }
        });
    }

    private void setUnlockedState() {
        removeAll();
        add(selected);
        selected.setReadOnly(false);
        add(saveButton);
        add(cancelButton);
    }

    private void setLockedState() {
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
