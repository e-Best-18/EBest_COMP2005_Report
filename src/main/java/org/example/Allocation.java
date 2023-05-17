package org.example;

import com.google.gson.Gson;

public class Allocation {

    private int id;
    private int admissionID;
    private int employeeID;
    private String startTime;
    private String endTime;

    public static void deserialiseAllocations(String jsonString) {
        Gson gson = new Gson();
//        jsonString = "{'id':1,'admissionDate':'2020-11-28T16:45:00','dischargeDate':'2020-11-28T23:56:00','patientID':2}";

        System.out.println(jsonString);

        Allocation[] allocations = gson.fromJson(jsonString, Allocation[].class);
        for (Allocation allocation : allocations) {
            System.out.println(allocation.toString());
        }
    }

    public Allocation() {
        id = 0;
        admissionID = 1;
        employeeID = 2;
        startTime = "a";
        endTime = "b";
    }

    public Allocation(int id, int admissionID, int employeeID, String startTime, String endTime) {
        this.id = id;
        this.admissionID = admissionID;
        this.employeeID = employeeID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getID() {
        return id;
    }

    public int getAdmissionID() {
        return admissionID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return  "[Allocation ID: " + getID() + "\n" +
                " Admission ID: " + getAdmissionID() + "\n" +
                " Admission Date: " + getEmployeeID() + "\n" +
                " Discharge Date: " + getStartTime() + "\n" +
                " Patient ID: " + getEndTime() + "]";
    }
}
