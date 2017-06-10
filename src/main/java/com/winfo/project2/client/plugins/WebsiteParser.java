package com.winfo.project2.client.plugins;

import java.io.IOException;
import java.net.URL;
import com.winfo.project2.client.basic.data.Entity;
import com.winfo.project2.client.basic.data.Property;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.String;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 29.05.2017.
 */
public  class WebsiteParser {

    private String url;

    private static final int TIMEOUT_IN_MS = 5000;

    public WebsiteParser(String url) {
        this.url = url;
    }

    public Entity parse(){
        return newEntity();
    }

    private Document parseHtml(){
        Document doc = null;
        try {
            doc = Jsoup.parse(new URL(url), TIMEOUT_IN_MS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    private Elements docSelect(Document doc, String QuerryString){
        return doc.select(QuerryString);
    }

    private Elements elByTag(Document doc, String tag){
        Elements els = doc.getElementsByTag(tag);
        return  els;
    }

    private Entity newEntity() {

        Document doc = parseHtml();

        List<String> urllist = new ArrayList<String>() {{add(url);}};
        List<String> titlelist = new ArrayList<String>() {{add(doc.title());}};
        List<String> headingslist = new ArrayList<String>() {{

            for (Element link : elByTag(doc, "h1")) {
                add(link.text());
            }
            for (Element link : elByTag(doc, "h2")) {
                add(link.text());
            }
            for (Element link : elByTag(doc, "h3")) {
                add(link.text());
            }
            for (Element link : elByTag(doc, "h4")) {
                add(link.text());
            }
            for (Element link : elByTag(doc, "h5")) {
                add(link.text());
            }
            for (Element link : elByTag(doc, "h6")) {
                add(link.text());
            }
        }};
        List<String> accessedonlist = new ArrayList<String>() {{add(LocalDate.now().toString());}};
        List<String> shortenedurllist = new ArrayList<String>() {{add(url.replace("http://",""));}};

        Property url = new Property("url", "String", urllist);
        Property title = new Property("title","String" , titlelist);
        Property headings = new Property("headings", "string", headingslist);
        Property accessedOn = new Property("accessedOn", "date", accessedonlist);
        Property shortenedUrl = new Property("shortenedUrl", "string", shortenedurllist);

        Entity entity = new Entity();

        entity.setBacklink(this.url);
        entity.setClassification("website");
        entity.setCompleteText(docSelect(doc, "body").text());
        entity.setDatasource("internet");
        entity.addSourceProperty(url);
        entity.addSourceProperty(title);
        entity.addSourceProperty(headings);
        entity.addSourceProperty(accessedOn);
        entity.addSyntheticProperty(shortenedUrl);

        return entity;
    }
}




