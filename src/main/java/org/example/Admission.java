package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Admission {

    int id;
    String admissionDate;
    String dischargeDate;
    int patientID;

/*
    public static JSONArray getAdmissions(String baseURL) throws MalformedURLException {
        // HttpURLConnection

        URL url = new URL(baseURL);

        return Getter.getter(url);

    }
*/




    public static void setAdmission(JSONArray admissions, int index) {
//        JSONObject admission = (JSONObject) admissions.get(index);

        //using Getter.parseJsonToJsonArray(), create admission class instance

    }

}

