package com.winfo.project2.client.basic.GUI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;
import com.vaadin.ui.UI;
import com.winfo.project2.client.plugins.WebsiteParser;

import java.io.IOException;

/**
 * This GUI is the application entry point. A GUI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The GUI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField importurl = new TextField();
        importurl.setCaption("URL einfügen:");

        TextArea area = new TextArea("Parsed Website");
        area.setWidth("100%");
        area.setHeight("600px");

        Button button = new Button("Importieren");
        Registration registration = button.addClickListener(e -> {
            WebsiteParser websiteToParse = new WebsiteParser();

            try {
                area.setValue(websiteToParse);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });

        layout.addComponents(importurl, button, area );
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
