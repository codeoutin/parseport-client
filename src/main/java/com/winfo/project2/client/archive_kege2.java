package com.winfo.project2.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Kevin on 10.06.17.
 */
public class archive_kege2 {

    private String objectToJson(Object object) {
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



    //create a table (grid) with Entities
/*  Grid<Entity> grid = new Grid<>(Entity.class);
        grid.setItems(entityList);
    //add delete button(s)
        grid.addColumn(entity -> "Delete",
            new ButtonRenderer<>(clickEvent -> {
        server.deleteEntityByEid("/entities", clickEvent.getItem().getEid());
        entityList.remove(clickEvent.getItem());
        grid.setItems(entityList);
    }));
        grid.setWidth("100%");
    Button button = new Button("Save me");
    ServerConnector server = new ServerConnector("http://193.196.143.149:9090");
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
}
*/