package com.winfo.project2.client;

import javax.servlet.annotation.WebServlet;

import com.google.gson.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.UI;
import com.vaadin.ui.renderers.ButtonRenderer;

import java.util.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        ServerConnector server = new ServerConnector("http://localhost:8090");
        final VerticalLayout layout = new VerticalLayout();
        
        //read json through serverconnector into a Entity Object Array
        Gson gson = new Gson();
        String jsonObject = server.getResponse("/entities").toString();
        Entity entities[] = gson.fromJson(jsonObject, Entity[].class);
        List<Entity> entityList = new ArrayList(Arrays.asList(entities));

        //create a table (grid) with Entities
        Grid<Entity> grid = new Grid<>(Entity.class);
        grid.setItems(entityList);
        //add delete button(s)
        grid.addColumn(entity -> "Delete",
                new ButtonRenderer<>(clickEvent -> {
                    server.deleteEntityByEid("/entities", clickEvent.getItem().getEid());
                    entityList.remove(clickEvent.getItem());
                    grid.setItems(entityList);
                }));
        grid.setWidth("100%");

        //input form
        FormLayout form = new FormLayout();
        TextField loadedAt = new TextField("Loaded at");

        loadedAt.setValue("0");
        loadedAt.setRequiredIndicatorVisible(true);
        loadedAt.setIcon(FontAwesome.CLOCK_O);

        TextField datasource = new TextField("Datasource");
        datasource.setIcon(FontAwesome.DATABASE);
        datasource.setRequiredIndicatorVisible(true);

        TextField backlink = new TextField("Backlink");
        backlink.setIcon(FontAwesome.EXTERNAL_LINK);
        backlink.setRequiredIndicatorVisible(true);

        TextField classification = new TextField("Classification");
        classification.setIcon(FontAwesome.SITEMAP);
        classification.setRequiredIndicatorVisible(true);

        TextField completeText = new TextField("Complete Text");
        completeText.setIcon(FontAwesome.FILE_TEXT);
        completeText.setRequiredIndicatorVisible(true);

        form.addComponents(datasource, backlink, classification, completeText, loadedAt);

        Button button = new Button("Save me");
        form.addComponent(button);
        //Button click
        button.addClickListener( e -> {
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

            //refresh page (remove if possible!!) > refresh grid like above at the delete method > problem: form is still filled with data!
            Page.getCurrent().reload();
        });

        layout.addComponent(form);

        
        layout.addComponents(grid);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
