package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.Buffer;
import java.util.Objects;
import java.util.Scanner;

public class Getter {

    public static JSONArray parseJsonToJsonArray(String urlString) throws ParseException, IOException {

        String jsonText = "";

        if (urlString.startsWith("src/mock_objects/")) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(urlString));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    jsonText += line + "\n";
                }

                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                URL url = new URL(urlString);
                InputStream iS = url.openStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iS));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    jsonText += line + "\n";
                }

                iS.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        JSONParser parse = new JSONParser();
        return (JSONArray) parse.parse(jsonText);

    }

    public static JSONArray getter(URL url) {

        HttpURLConnection conn = null;

        try {

            conn = Connection.setConnection(url);

            int status = Connection.getResponseCode(url);

            if (status != 200) {
                throw new RuntimeException(String.valueOf(status));
            } else {

                return parseJsonToJsonArray(url.toString());

            }

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            conn.disconnect();
        }

    }

}
