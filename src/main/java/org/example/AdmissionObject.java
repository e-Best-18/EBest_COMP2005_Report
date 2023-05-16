package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AdmissionObject {

    int id;
    String admissionDate;
    String dischargeDate;
    int patientID;

    public static JSONArray parseAdmissionJSON(String informationString) throws ParseException {
        JSONParser parse = new JSONParser();
        return (JSONArray) parse.parse(String.valueOf(informationString));
    }
}
