package org.example;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {


        String baseURL = "https://web.socem.plymouth.ac.uk/COMP2005/api/";


        JSONArray testerAd = Getter.parseJsonToJsonArray("src/mock_objects/mockAdmissionsArray.json");
        JSONArray testerAl = Getter.parseJsonToJsonArray("src/mock_objects/mockAllocationsArray.json");


        JSONArray admissions = Getter.parseJsonToJsonArray(baseURL + "Admissions");
        JSONArray allocations = Getter.parseJsonToJsonArray(baseURL + "Allocations");
        JSONArray employees = Getter.parseJsonToJsonArray(baseURL + "Employees");
        JSONArray patients = Getter.parseJsonToJsonArray(baseURL + "Patients");



/*
        JSONObject admission = (JSONObject) admissions.get(0);
        JSONObject allocation = (JSONObject) allocations.get(0);
        JSONObject employee = (JSONObject) employees.get(0);
        JSONObject patient = (JSONObject) patients.get(0);
*/



        System.out.println(testerAd);
        System.out.println(testerAl);
        System.out.println(admissions);
        System.out.println(allocations);
        System.out.println(employees);
        System.out.println(patients);


    }
}