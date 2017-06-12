package com.winfo.project2.client.basic.GUI;

import com.google.gson.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.*;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.winfo.project2.client.basic.connection.ServerConnector;
import com.winfo.project2.client.basic.data.Entity;

import java.util.*;


/**
 * Created by patrick on 12.06.17.
 */
@Theme("mytheme")
public class UploadUILogic extends UploadUI {
    protected void init(VaadinRequest vaadinRequest) {
        ServerConnector server = new ServerConnector();
        final VerticalLayout layout = new VerticalLayout();

        //read json through serverconnector into a Entity Object Array
        Gson gson = new Gson();
        String jsonObject = server.getResponse("http://localhost:8090/entities").toString();
        Entity entities[] = gson.fromJson(jsonObject, Entity[].class);
        List<Entity> entityList = new ArrayList(Arrays.asList(entities));

        //create a table (grid) with Entities
        Grid<Entity> grid = new Grid<>(Entity.class);
        grid.setItems(entityList);
        grid.setWidth("100%");

        layout.addComponents(grid);

        //setContent(layout);
    }

}
