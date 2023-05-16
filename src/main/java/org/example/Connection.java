package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    public static HttpURLConnection connect(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Request setup
        connection.setRequestMethod("GET");
        connection.connect();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        return connection;
    }

    public static int getResponseCode(URL url) throws IOException {

        HttpURLConnection connection = connect(url);

        return connection.getResponseCode();
    }

}
