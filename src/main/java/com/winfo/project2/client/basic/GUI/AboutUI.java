package com.winfo.project2.client.basic.GUI;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AboutUI extends MainUI{
    public static final String VIEW_NAME = "about";

    public AboutUI(){
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        headerLabel.setStyleName("h1");
        Label infoLabel = new Label();
        infoLabel.setStyleName("p");
        VerticalLayout vertical = new VerticalLayout ();

        headerLabel.setValue("About ParsePort");
        infoLabel.setValue("ParsePort is a company which started in 2017 as a group of ten students from the" +
                " \"University of Applied Sciences\" in Stuttgart. " +
                "All of them are studying Business and Information Systems Engineering.");
        infoLabel.setWidth("70%");

        vertical.addComponents(headerLabel, infoLabel);

//        mainContent.removeAllComponents();
//        mainContent.addComponents(vertical);

        return vertical;
    }
}
