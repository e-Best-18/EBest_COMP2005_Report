package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AllocationObject {

    int id;
    int admissionID;
    int employeeID;
    String startTime;
    String  endTime;

    public static JSONArray parseAllocationJSON(String informationString) throws ParseException {
        JSONParser parse = new JSONParser();
        return (JSONArray) parse.parse(String.valueOf(informationString));
    }
}
