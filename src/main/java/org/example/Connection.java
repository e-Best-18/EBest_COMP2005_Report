package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Connection {

    public static HttpURLConnection setConnection(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Request setup
        connection.setRequestMethod("GET");
        connection.connect();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        return connection;
    }


    public static int getResponseCode(URL url) throws IOException {

        HttpURLConnection connection = setConnection(url);

        return connection.getResponseCode();
    }

}
