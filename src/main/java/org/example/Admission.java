package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;


public class Admission {

    static int id;
    static String admissionDate;
    static String dischargeDate;
    static int patientID;

    public static void deserialiseAdmission(String jsonString) {
        Gson gson = new Gson();
        Admission admission = gson.fromJson(jsonString, Admission.class);
        System.out.println(admission);
    }

/*
    @Override
    public String toString() {
        return "[ Admission ID: " + getId() +
                " Admission Date: " + getAdmissionDate() +
                " Discharge Date: " + getDischargeDate() +
                " Patient ID: " + getPatientID() + " ]";
    }
*/

}

