package org.example;

import org.json.simple.*;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        String baseURL = "https://web.socem.plymouth.ac.uk/COMP2005/api/";

        JSONArray admissions = GetAdmissions.getAdmissions(baseURL + "Admissions");
        JSONArray allocations = GetAllocations.getAllocations(baseURL + "Allocations");
        JSONArray employees = GetEmployees.getEmployees(baseURL + "Employees");
        JSONArray patients = GetPatients.getPatients(baseURL + "Patients");

        JSONObject admission = (JSONObject) admissions.get(0);
        JSONObject allocation = (JSONObject) allocations.get(0);
        JSONObject employee = (JSONObject) employees.get(0);
        JSONObject patient = (JSONObject) patients.get(0);


        System.out.println(admission);
        System.out.println(allocation);
        System.out.println(employee);
        System.out.println(patient);

    }
}