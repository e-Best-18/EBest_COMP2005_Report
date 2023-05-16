package org.example;

import org.json.simple.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

public class GetAllocations {

    public static JSONArray getAllocations(String baseURL) throws MalformedURLException {
        // HttpURLConnection

        URL url = new URL(baseURL);

        return Getter.getter(url);

    }

}