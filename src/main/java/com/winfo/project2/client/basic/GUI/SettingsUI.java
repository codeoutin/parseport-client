package com.winfo.project2.client.basic.GUI;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.TextField;
import com.winfo.project2.client.basic.data.Settings;
import com.winfo.project2.client.basic.helper;


/**
 * Created by patrick on 13.06.17.
 */
public class SettingsUI extends MainUI {
    public SettingsUI() {
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        TextField ip = new TextField();
        TextField port = new TextField();
        Button saveButton = new Button("Save");
        headerLabel.setStyleName("h1");
        VerticalLayout vertical = new VerticalLayout ();

        headerLabel.setValue("Settings");

        ip.setCaption("IP-address");
        port.setCaption("Port");
        saveButton.addClickListener(e -> {
            //kevin mach mal fertig ;) >> setSettings und dann ip.getValue() und port.getValue()
            //helper.setSettings().??;
            vertical.addComponent(new Label("Settings saved!"));
        });

        //get Settings
        ip.setValue(helper.getSettings().getIpaddress());
        port.setValue(helper.getSettings().getPort());


        vertical.addComponents(headerLabel, ip, port, saveButton);

//        mainContent.removeAllComponents();
//        mainContent.addComponents(vertical);

        return vertical;
    }
}
