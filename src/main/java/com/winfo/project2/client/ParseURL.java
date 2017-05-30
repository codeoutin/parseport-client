package com.winfo.project2.client;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Thomas on 29.05.2017.
 */
public class ParseURL {

        private static final int TIMEOUT_IN_MS = 5000;

        public static void parse() throws MalformedURLException, IOException
        {
            Document doc = Jsoup.parse(new URL("www.hft-stuttgart.de") , TIMEOUT_IN_MS);

            System.out.println(doc.html());

        }

    }


