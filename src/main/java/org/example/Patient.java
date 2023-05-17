package org.example;

import com.google.gson.Gson;

public class Patient {

    private int id;
    private String surname;
    private String forename;
    private String nhsNumber;


    public static void deserialisePatients(String jsonString) {
        Gson gson = new Gson();
//        jsonString = "{'id':1,'admissionDate':'2020-11-28T16:45:00','dischargeDate':'2020-11-28T23:56:00','patientID':2}";

        System.out.println(jsonString);

        Patient[] patients = gson.fromJson(jsonString, Patient[].class);
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }

    public Patient() {
        id = 0;
        String surname = "a";
        String forename = "b";
        String nhsNumber = "1";
    }

    public Patient(int id, String surname, String forename, String nhsNumber) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
        this.nhsNumber = nhsNumber;
    }

    public int getID() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    @Override
    public String toString() {
        return  "[Patient ID: " + getID() + "\n" +
                " Surname: " + getSurname() + "\n" +
                " Forename: " + getForename() + "\n" +
                " NHS Number: " + getNhsNumber() + "]";
    }
}
