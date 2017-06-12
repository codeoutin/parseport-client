package com.winfo.project2.client.basic.GUI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.winfo.project2.client.basic.data.ApplicationPreference;

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

        /*if(!ap.getPreference("ipadress").equals("") || !ap.getPreference("port").equals("") ) {
            settingsUI.ipTextfield.setValue(ap.getPreference("ipaddress"));
            settingsUI.portTextfield.setValue(ap.getPreference("port"));
        }*/

        //Click Listener for navigation between the pages
        mainUI.homepageButton.addClickListener(e -> {
            setContent(mainUI);
        });

        mainUI.settingsButton.addClickListener(e -> {
            setContent(settingsUI);
        });

        mainUI.aboutbutton.addClickListener(e -> {
            setContent(aboutUI);
        });

        mainUI.contactButton.addClickListener(e -> {
            setContent(contactUI);
        });

        mainUI.uploadButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        mainUI.impressumButton.addClickListener(e -> {
            setContent(impressumUI);
        });

        uploadUI.homepageButton.addClickListener(e -> {
            setContent(mainUI);
        });

        uploadUI.settingsButton.addClickListener(e -> {
            setContent(settingsUI);
        });

        uploadUI.aboutbutton.addClickListener(e -> {
            setContent(aboutUI);
        });

        uploadUI.contactButton.addClickListener(e -> {
            setContent(contactUI);
        });

        uploadUI.uploadButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        uploadUI.impressumButton.addClickListener(e -> {
            setContent(impressumUI);
        });

        aboutUI.homepageButton.addClickListener(e -> {
            setContent(mainUI);
        });

        aboutUI.settingsButton.addClickListener(e -> {
            setContent(settingsUI);
        });

        aboutUI.aboutbutton.addClickListener(e -> {
            setContent(aboutUI);
        });

        aboutUI.contactButton.addClickListener(e -> {
            setContent(contactUI);
        });

        aboutUI.uploadButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        aboutUI.impressumButton.addClickListener(e -> {
            setContent(impressumUI);
        });

        settingsUI.homepageButton.addClickListener(e -> {
            setContent(mainUI);
        });

        settingsUI.settingsButton.addClickListener(e -> {
            setContent(settingsUI);
        });

        settingsUI.aboutbutton.addClickListener(e -> {
            setContent(aboutUI);
        });

        settingsUI.contactButton.addClickListener(e -> {
            setContent(contactUI);
        });

        settingsUI.uploadsButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        settingsUI.impressumButton.addClickListener(e -> {
            setContent(impressumUI);
        });

        settingsUI.safeButton.addClickListener(e -> {
            settingsUI.safeLabel.setVisible(true);
            ApplicationPreference.setPreference("ipaddress", settingsUI.ipTextfield.getValue());
            ApplicationPreference.setPreference("port", settingsUI.portTextfield.getValue());
        });

        contactUI.homepageButton.addClickListener(e -> {
            setContent(mainUI);
        });

        contactUI.settingsButton.addClickListener(e -> {
            setContent(settingsUI);
        });

        contactUI.aboutbutton.addClickListener(e -> {
            setContent(aboutUI);
        });

        contactUI.contactButton.addClickListener(e -> {
            setContent(contactUI);
        });

        contactUI.uploadButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        contactUI.impressumButton.addClickListener(e -> {
            setContent(impressumUI);
        });

        setContent(mainUI);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ClientUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
