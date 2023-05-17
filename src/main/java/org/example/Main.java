package org.example;

import com.google.gson.Gson;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {


        String baseURL = "https://web.socem.plymouth.ac.uk/COMP2005/api/";

        JSONArray array = Getter.parseJsonToJsonArray(baseURL + "Employees");

        Employee.deserialiseEmployees(array.toJSONString());

//        getPatientByEmployeeID();

/*
        JSONArray testerAd = Getter.parseJsonToJsonArray("src/mock_objects/mockAdmissionsArray");
        JSONArray testerAl = Getter.parseJsonToJsonArray("src/mock_objects/mockAllocationsArray");


        JSONArray admissions = Getter.parseJsonToJsonArray(baseURL + "Admissions");
        JSONArray allocations = Getter.parseJsonToJsonArray(baseURL + "Allocations");
        JSONArray employees = Getter.parseJsonToJsonArray(baseURL + "Employees");
        JSONArray patients = Getter.parseJsonToJsonArray(baseURL + "Patients");
*/



/*
        JSONObject admission = (JSONObject) admissions.get(0);
        JSONObject allocation = (JSONObject) allocations.get(0);
        JSONObject employee = (JSONObject) employees.get(0);
        JSONObject patient = (JSONObject) patients.get(0);
*/



/*
        System.out.println(testerAd);
        System.out.println(testerAl);
        System.out.println(admissions);
        System.out.println(allocations);
        System.out.println(employees);
        System.out.println(patients);
*/


    }

    public static void getPatientByEmployeeID() throws IOException {
        Scanner userInput = new Scanner(System.in);
        int employeeID = userInput.nextInt();
        userInput.close();
        System.out.println("you typed: " + employeeID);
    }

}