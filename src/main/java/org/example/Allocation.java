package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.MalformedURLException;
import java.net.URL;

public class Allocation {

    int id;
    int admissionID;
    int employeeID;
    String startTime;
    String  endTime;

    public static JSONArray getAllocations(String baseURL) throws MalformedURLException {
        // HttpURLConnection

        URL url = new URL(baseURL);

        return Getter.getter(url);

    }

    public static JSONArray parseAllocationJSON(String informationString) throws ParseException {
        JSONParser parse = new JSONParser();
        return (JSONArray) parse.parse(String.valueOf(informationString));
    }

}

