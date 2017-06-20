package com.winfo.project2.client.basic.GUI;

import com.google.gson.*;
import com.sun.jersey.api.client.ClientHandlerException;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.winfo.project2.client.basic.connection.ServerConnector;
import com.winfo.project2.client.basic.data.Entity;
import com.winfo.project2.client.basic.data.Settings;
import com.winfo.project2.client.basic.helper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by patrick on 13.06.17.
 */
public class DataUI extends MainUI{
    public static final String VIEW_NAME = "data";
    Label status = new Label();
    VerticalLayout vertical = new VerticalLayout ();
    Grid<Entity> grid = new Grid<>(Entity.class);

    Settings settings = helper.getSettings();

    final ServerConnector server = new ServerConnector("http://" + settings.getIpaddress() + ":" + settings.getPort());

    public DataUI() {
    }

    private void loadDataInThread() {
        new Thread(() -> {
            //read json through serverconnector into a Entity Object Array
            Gson gson = new Gson();

            //set fail message
            status.setValue("Server Connection failed. Connect to VPN and try again.");
            vertical.addComponent(status);

            try {
                String jsonObject = server.getResponse("/entities").toString();
                Entity entities[] = gson.fromJson(jsonObject, Entity[].class);
                List<Entity> entityList = new ArrayList(Arrays.asList(entities));

                //add delete button(s)
                grid.addColumn(entity -> "Delete",
                        new ButtonRenderer<>(clickEvent -> {
                            server.deleteEntityByEid("/entities", clickEvent.getItem().getEid());
                            entityList.remove(clickEvent.getItem());
                            grid.setItems(entityList);
                        }));

                //set items for grid
                if(!entityList.isEmpty()) {
                    vertical.removeComponent(status);
                    grid.setItems(entityList);
                    vertical.addComponent(grid);
                } else {
                    grid.setEnabled(false);
                }
                grid.setWidth("100%");
                grid.setHeight("90%");
                grid.getColumn("completeText").setWidth(500);
                grid.getColumn("backlink").setWidth(300);

            } catch (ClientHandlerException e) {
                new Notification("Timeout: " + e.getMessage());
            }
        }).start();
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        headerLabel.setStyleName("h1");
        headerLabel.setValue("Data");

        vertical.addComponent(headerLabel);

        //start creating grid
        try {
            loadDataInThread();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return vertical;
    }
}
