package com.winfo.project2.client.basic.GUI;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

/**
 * Created by patrick on 13.06.17.
 */
public class ContactUI extends MainUI {
    public static final String VIEW_NAME = "contact";

    public ContactUI() {
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        headerLabel.setStyleName("h1");
        Label infoLabel = new Label();
        infoLabel.setStyleName("p");
        VerticalLayout vertical = new VerticalLayout ();

        headerLabel.setValue("Contact Us");
        infoLabel.setValue("<b>Hochschule für Technik Stuttgart</b><br>" +
                "Schellingstr. 24<br>" +
                "70174 Stuttgart<br>" +
                "<a target='_blank' href='//www.hft-stuttgart.de'>www.hft-stuttgart.de</a>");
        infoLabel.setWidth("70%");
        infoLabel.setContentMode(ContentMode.HTML);

        vertical.addComponents(headerLabel, infoLabel);

//        mainContent.removeAllComponents();
//        mainContent.addComponent(vertical);

        return vertical;
    }
}
