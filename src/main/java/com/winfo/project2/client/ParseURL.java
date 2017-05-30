package com.winfo.project2.client;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.json.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.lang.String;

/**
 * Created by Thomas on 29.05.2017.
 */
public class ParseURL {

        private static final int TIMEOUT_IN_MS = 5000;

        public static void main(String[] args) throws MalformedURLException, IOException
        {
            Document doc = Jsoup.parse(new URL("https://www.google.de/") , TIMEOUT_IN_MS);

            System.out.println(doc.html());


            //System.out.println(doc.html());

            String html = doc.toString();

            //System.out.println(html);

            //JSONParser parser = new JSONParser();
            //JSONObject json = (JSONObject) parser.parse(html);
            //JSONObject jsonObj = new JSONObject(html);
            //System.out.println(jsonObj);
            //var htmlparser = require("htmlparser2");
            //elements = htmlparser.parseDOM(htmlString);

        }

    }


