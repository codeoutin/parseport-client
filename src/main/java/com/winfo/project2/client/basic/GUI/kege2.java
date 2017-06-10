package com.winfo.project2.client.basic.GUI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Kevin on 10.06.17.
 */
public class kege2 {

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
