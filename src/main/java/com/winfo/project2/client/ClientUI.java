package com.winfo.project2.client;

import javax.servlet.annotation.WebServlet;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class ClientUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final MainUI mainUI = new MainUI();
        final SettingsUI settingsUI = new SettingsUI();
        final AboutUI aboutUI = new AboutUI();
        final ContactUI contactUI = new ContactUI();
        final UploadUI uploadUI = new UploadUI();
        final ImpressumUI impressumUI = new ImpressumUI();

        mainUI.homepageButton.addClickListener( e -> {
            setContent(mainUI);
        });

        mainUI.settingsButton.addClickListener( e -> {
            setContent(settingsUI);
        });

        mainUI.aboutbutton.addClickListener( e -> {
            setContent(aboutUI);
        });

        mainUI.contactButton.addClickListener( e -> {
            setContent(contactUI);
        });

        mainUI.uploadButton.addClickListener( e -> {
            setContent(uploadUI);
        });

        mainUI.impressumButton.addClickListener( e -> {
            setContent(impressumUI);
        });

        settingsUI.safeButton.addClickListener( e -> {
            settingsUI.safeLabel.setVisible(true);
        });


        setContent(mainUI);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ClientUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
