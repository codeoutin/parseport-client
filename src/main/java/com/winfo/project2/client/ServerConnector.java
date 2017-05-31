package com.winfo.project2.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;


/**
 * Created by patrick on 24.05.17.
 */
public class ServerConnector{

    ServerConnector()
    {

    }

    public JSONArray getResponse(String resourceUrl) {
        try {
            Client client = Client.create();
            WebResource webResource2 = client.resource(resourceUrl);
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

    public void postJSON(String input, String resourceUrl) {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(resourceUrl);

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, input);

            // check response status code
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
