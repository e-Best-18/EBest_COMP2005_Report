package org.example;

import org.json.simple.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

public class GetEmployees {

    public static JSONArray getEmployees(String baseURL) throws MalformedURLException {
        // HttpURLConnection

        URL url = new URL(baseURL);

        return Getter.getter(url);

    }

}