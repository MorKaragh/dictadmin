package com.morkaragh.dictadmin.ui.common;

import com.vaadin.flow.component.html.Div;

public class Label {


    public static Div varSize(String text, String fontSize, String width) {
        Div idLabel = new Div();
        idLabel.setText(text);
        idLabel.getStyle()
                .set("font-size", fontSize)
                .set("color", "black");
        idLabel.setWidth(width);
        return idLabel;
    }


}
