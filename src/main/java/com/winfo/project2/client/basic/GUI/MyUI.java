package com.winfo.project2.client.basic.GUI;

import javax.servlet.annotation.WebServlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;
import com.vaadin.ui.UI;
import com.winfo.project2.client.plugins.WebsiteParser;



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

        TextArea area = new TextArea("preview parsed website");
        area.setWidth("100%");
        area.setHeight("600px");

        Button button = new Button("parse");
        Registration registration = button.addClickListener(e -> {
            WebsiteParser websiteParser = new WebsiteParser(importurl.getValue());
            area.setValue(objectToJson(websiteParser.parse()));

        });

        layout.addComponents(importurl, button, area );
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private String objectToJson(Object object){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            return jsonInString;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
