package com.winfo.project2.client.basic.GUI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.winfo.project2.client.basic.connection.ServerConnector;
import com.winfo.project2.client.basic.data.Entity;

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
        final UploadedUI uploadedUI = new UploadedUI();


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

        mainUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
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

        uploadUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
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

        aboutUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
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

        settingsUI.uploaDataButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        settingsUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
        });

        settingsUI.saveButton.addClickListener(e -> {
            settingsUI.saveLabel.setVisible(true);
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

        contactUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
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

        contactUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
        });

        uploadedUI.homepageButton.addClickListener(e -> {
            setContent(mainUI);
        });

        uploadedUI.settingsButton.addClickListener(e -> {
            setContent(settingsUI);
        });

        uploadedUI.aboutbutton.addClickListener(e -> {
            setContent(aboutUI);
        });

        uploadedUI.contactButton.addClickListener(e -> {
            setContent(contactUI);
        });

        uploadedUI.uploadButton.addClickListener(e -> {
            setContent(uploadUI);
        });

        uploadedUI.uploadsButton.addClickListener(e -> {
            setContent(uploadedUI);
        });

/*
        ServerConnector server = new ServerConnector("http://193.196.143.149:9090");
        //create a table (grid) with Entities
        uploadedUI.dataGrid.setItems("entitylist");
        //add delete button(s)
        uploadedUI.dataGrid.addColumn(entity -> "Delete",
                new ButtonRenderer<>(clickEvent -> {
                    server.deleteEntityByEid("/entities", clickEvent.getItem().getEid());
                    entityList.remove(clickEvent.getItem());
                    uploadedUI.dataGrid.setItems("entityList");
                }));
        uploadedUI.dataGrid.setWidth("100%");
*/

    /*    Button button = new Button("Save me");
        button.addClickListener(e -> {
            //create new entity object
            Entity en = new Entity(datasource.getValue(), backlink.getValue(), classification.getValue(), Integer.valueOf(loadedAt.getValue()), completeText.getValue());
            //show notification
//            Notification.show("Data saved",
//                    "Input saved in datebase!",
//                    Notification.Type.HUMANIZED_MESSAGE);
            //create json out of new object
            String newEntityJson = gson.toJson(en);
            //post json through serverconnector
            server.postJSON("/entities", newEntityJson);
        });*/

        setContent(mainUI);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ClientUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
