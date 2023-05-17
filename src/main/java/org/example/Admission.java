package org.example;

import com.google.gson.Gson;

public class Admission {

    private int id;
    private String admissionDate;
    private String dischargeDate;
    private int patientID;

    public static Admission[] deserialiseAdmissions(String jsonString) {
        Gson gson = new Gson();
//        jsonString = "{'id':1,'admissionDate':'2020-11-28T16:45:00','dischargeDate':'2020-11-28T23:56:00','patientID':2}";

//        System.out.println(jsonString);

        Admission[] admissions = gson.fromJson(jsonString, Admission[].class);
/*
        for (Admission admission : admissions) {
            System.out.println(admission.toString());
        }
*/
        return admissions;
    }

    public Admission() {
        id = 0;
        admissionDate = "a";
        dischargeDate = "b";
        patientID = 2;
    }

    public Admission(int id, String admissionDate, String dischargeDate, int patientID) {
        this.id = id;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.patientID = patientID;
    }

    public int getID() {
        return id;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public int getPatientID() {
        return patientID;
    }

    @Override
    public String toString() {
        return "[Admission ID: " + getID() + "\n" +
                " Admission Date: " + getAdmissionDate() + "\n" +
                " Discharge Date: " + getDischargeDate() + "\n" +
                " Patient ID: " + getPatientID() + "]";
    }
}

