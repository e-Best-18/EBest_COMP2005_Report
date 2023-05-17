package org.example;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.example.DateChecker.dateChecker;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {


        String baseURL = "https://web.socem.plymouth.ac.uk/COMP2005/api/";

/*
        JSONArray array = Getter.parseJsonToJsonArray(baseURL + "Employees");

        Employee[] employees = Employee.deserialiseEmployees(array.toJSONString());

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
*/

//        getPatientByEmployeeID();
        getPatientsDischargedIn3Days(baseURL);
    }

/*
    public static void getPatientByEmployeeID(String baseURL) throws IOException, ParseException {
        Scanner userInput = new Scanner(System.in);
        int employeeID = userInput.nextInt();
        userInput.close();
        System.out.println("you typed: " + employeeID);

        JSONArray array = Getter.parseJsonToJsonArray(baseURL + "Allocations");

        Employee[] employees = Employee.deserialiseEmployees(array.toJSONString());
    }
*/

    public static ArrayList<Patient> getPatientsDischargedIn3Days(String baseURL) throws ParseException, IOException, java.text.ParseException {

        ArrayList<Integer> patientIDs = new ArrayList<Integer>();
        ArrayList<Patient> patientArrayList = new ArrayList<>();

        // get admissions
        JSONArray arrayAdmissions = Getter.parseJsonToJsonArray(baseURL + "Admissions");
        Admission[] admissions = Admission.deserialiseAdmissions(arrayAdmissions.toJSONString());
        // select admissions with < 3 days stay
        for (Admission admission : admissions) {
            if (dateChecker(admission.getAdmissionDate(), admission.getDischargeDate())) {
                patientIDs.add(admission.getPatientID());
            }
        }
        // extract patient ID
        JSONArray arrayPatients = Getter.parseJsonToJsonArray(baseURL + "Patients");
        Patient[] patients = Patient.deserialisePatients(arrayPatients.toJSONString());
        for (Patient patient : patients) {
            for (Integer id : patientIDs) {
                if (patient.getID() == id) {
                    patientArrayList.add(patient);
                }
            }
        }
        // return patients
        System.out.println(patientArrayList);
        return patientArrayList;
    }

}