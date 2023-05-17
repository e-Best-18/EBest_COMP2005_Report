package org.example;

import com.google.gson.Gson;

public class Employee {

    private int id;
    private String surname;
    private String forename;


    public static Employee[] deserialiseEmployees(String jsonString) {
        Gson gson = new Gson();
//        jsonString = "{'id':1,'admissionDate':'2020-11-28T16:45:00','dischargeDate':'2020-11-28T23:56:00','patientID':2}";

//        System.out.println(jsonString);

        Employee[] employees = gson.fromJson(jsonString, Employee[].class);
/*
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
*/

        return employees;
    }

    public Employee() {
        id = 0;
        String surname = "a";
        String forename = "b";
    }

    public Employee(int id, String surname, String forename, String nhsNumber) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
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

    @Override
    public String toString() {
        return  "[Patient ID: " + getID() + "\n" +
                " Surname: " + getSurname() + "\n" +
                " Forename: " + getForename() + "]";
    }
}
