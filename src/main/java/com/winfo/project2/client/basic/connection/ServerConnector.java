package com.winfo.project2.client.basic.connection;

import com.sun.jersey.api.client.*;
import org.json.JSONArray;


/**
 * Created by patrick on 24.05.17.
 */
public class ServerConnector{

    private String resourceUrl;

    public ServerConnector(String resourceUrl)
    {
        this.resourceUrl = resourceUrl;
    }

    public JSONArray getResponse(String path) {
        try {
            Client client = Client.create();
            WebResource webResource2 = client.resource(resourceUrl + path);
            ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
            if (response2.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
            }

            JSONArray obj = new JSONArray(response2.getEntity(String.class));
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int postJSON(String path, String input) {

            Client client = Client.create();

            WebResource webResource = client.resource(resourceUrl + path);

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, input);
            return response.getStatus();
    }

    public void deleteEntityByEid(String path, String eId) {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(resourceUrl + path + "/" + eId);

            // Delete method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").delete(ClientResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
