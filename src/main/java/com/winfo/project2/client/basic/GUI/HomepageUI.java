package com.winfo.project2.client.basic.GUI;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by patrick on 13.06.17.
 */
public class HomepageUI {
    public HomepageUI() {
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        headerLabel.setStyleName("h1");
        Label infoLabel = new Label();
        infoLabel.setStyleName("p");
        VerticalLayout vertical = new VerticalLayout ();

        headerLabel.setValue("ParsePort");
        infoLabel.setValue("Edit me, i'll wait at HomepageUI::21");
        infoLabel.setWidth("70%");

        vertical.addComponents(headerLabel, infoLabel);

//        mainContent.removeAllComponents();
//        mainContent.addComponents(vertical);

        return vertical;
    }
}
