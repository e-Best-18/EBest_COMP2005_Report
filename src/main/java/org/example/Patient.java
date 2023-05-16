package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.MalformedURLException;
import java.net.URL;

public class Patient {

    int id;
    String surname;
    String forename;
    String nhsNumber;

    public static JSONArray getPatients(String baseURL) throws MalformedURLException {
        // HttpURLConnection

        URL url = new URL(baseURL);

        return Getter.getter(url);

    }

    public static JSONArray parsePatientJSON(String informationString) throws ParseException {
        JSONParser parse = new JSONParser();
        return (JSONArray) parse.parse(String.valueOf(informationString));
    }

}

