package com.winfo.project2.client.plugins;

import java.io.IOException;
import java.net.URL;

import com.winfo.project2.client.basic.data.Entity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.String;
import java.util.ArrayList;

/**
 * Created by Thomas on 29.05.2017.
 */
public class WebsiteParser {

    public String url;

    private static final int TIMEOUT_IN_MS = 5000;

    public WebsiteParser(String url) throws IOException {
        this.url = url;
    }

    private String parse(String QuerryString){

        Document doc = null;
        try {
            doc = Jsoup.parse(new URL(url), TIMEOUT_IN_MS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements el = doc.select(QuerryString);

        return el.toString();
    }

    private newEntity() {
        Entity entity = new Entity();
        entity.setBacklink(url);
        entity.setClassification("website");
        entity.setCompleteText(parse("body"));
        entity.setDatasource("internet");

    }
}




