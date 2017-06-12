package com.winfo.project2.client.basic.GUI;

import com.google.gson.*;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.winfo.project2.client.basic.connection.ServerConnector;
import com.winfo.project2.client.basic.data.Entity;
import com.winfo.project2.client.basic.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by patrick on 13.06.17.
 */
public class DataUI extends MainUI {
    public DataUI() {
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        headerLabel.setStyleName("h1");
        VerticalLayout vertical = new VerticalLayout ();


        headerLabel.setValue("Data");

        //Timeout wäre coooool

        ServerConnector server = new ServerConnector("http://" + helper.getSettings().getIpaddress() + ":" + helper.getSettings().getPort());


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



        vertical.addComponents(headerLabel, grid);

//        mainContent.removeAllComponents();
//        mainContent.addComponents(vertical);

        return vertical;
    }
}
