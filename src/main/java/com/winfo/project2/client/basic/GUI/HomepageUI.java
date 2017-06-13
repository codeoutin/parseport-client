package com.winfo.project2.client.basic.GUI;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by patrick on 13.06.17.
 */
public class HomepageUI {
    public static final String VIEW_NAME = "home";

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

        Label loremIpsum = new Label();
        loremIpsum.setValue("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        loremIpsum.setWidth("70%");


        vertical.addComponents(headerLabel, infoLabel, loremIpsum);

//        mainContent.removeAllComponents();
//        mainContent.addComponents(vertical);

        return vertical;
    }
}
