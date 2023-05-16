package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;

// Run all tests
@RunWith(Enclosed.class)
public class RunTests {

    @RunWith(Parameterized.class)
    public static class ResponseCodeTest {

        private static URL url;
        private static Connection connection;
        private static int expectedCode;


        @Before
        public void initialise() {
            connection = new Connection();
        }

        public ResponseCodeTest(String urlString, int expectedCode) throws MalformedURLException {
            this.url = new URL(urlString);
            this.expectedCode = expectedCode;
        }

        @Parameterized.Parameters
        public static Collection responseCodeTestCollection() {
            return Arrays.asList(new Object[][]{
                    {"https://web.socem.plymouth.ac.uk/COMP2005/api/Admissions", 200},
                    {"https://web.socem.plymouth.ac.uk/COMP2005/api/Allocations", 200},
                    {"https://web.socem.plymouth.ac.uk/COMP2005/api/Employees", 200},
                    {"https://web.socem.plymouth.ac.uk/COMP2005/api/Patients", 200},
                    {"https://web.socem.plymouth.ac.uk/COMP2005/api/Admis", 404},
            });
        }


        // Asserting that the URL actually points to an endpoint
        @Test
        public void responseCodeTest() throws IOException {
            assertEquals(expectedCode, connection.getResponseCode(url));
        }

    }

    public static class ExceptionTest {

        private Connection connection;

        @Before
        public void initialise() {
            connection = new Connection();
        }

        @Rule
        public ExpectedException exceptionRule = ExpectedException.none();

        @Test(expected = MalformedURLException.class)
        public void malformedURLExceptionThrownTest() throws IOException {
            URL url = new URL("web.socem.plymouth.ac.uk/COMP2005/api/Allocations");
            exceptionRule.expect(MalformedURLException.class);
            connection.getResponseCode(url);
        }
    }


    public static class ParsingJSONTest {

        private static Admission admission;

        private final int id = 1;
        private final String admissionDate = "2022-02-22T11:11:11";
        private final String dischargeDate = "2022-02-22T22:22:22";
        private final int patientID = 2;

        @Before
        public void initialize() {
            admission = new Admission();
        }

        @Test
        public void admissionParsingShouldMatchJSON() throws ParseException, IOException {

            String mockJSONFile = "src/mock_objects/mockAdmissionsArray.json";

            JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);

            JSONObject jsonObject = (JSONObject) jsonArray.get(0);

            String expected = jsonObject.get("id").toString();

            assertEquals(expected, "1");

        }

        @Test
        public void allocationParsingShouldMatchJSON () throws ParseException, IOException {
            for (int i = 0; i < 3; i++) {

                String mockJSONFile = "src/mock_objects/mockAllocationsArray.json";

                JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                String expected = jsonObject.get("id").toString();

                assertEquals(expected, "1");
            }

        }

    }

}