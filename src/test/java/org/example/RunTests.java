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

import static junit.framework.Assert.*;

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
                    {"https://web.socem.plymouth.ac.uk/COMP2005/api/Admis", 404}
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

        @Test
        public void admissionParsingShouldMatchJSON() throws ParseException, IOException {
            String mockJSONFile = "src/mock_objects/mockAdmissionsArray";
            JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);
            JSONObject jsonObject = (JSONObject) jsonArray.get(1);
            assertEquals(jsonObject.get("id").toString(), "2");
            assertEquals(jsonObject.get("admissionDate").toString(), "2020-12-31T23:59:00");
            assertEquals(jsonObject.get("dischargeDate").toString(), "2021-01-01T00:00:00");
            assertEquals(jsonObject.get("patientID").toString(), "1");
        }
        @Test
        public void allocationParsingShouldMatchJSON () throws ParseException, IOException {
            String mockJSONFile = "src/mock_objects/mockAllocationsArray";
            JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            assertEquals(jsonObject.get("id").toString(), "9");
            assertEquals(jsonObject.get("admissionID").toString(), "1");
            assertEquals(jsonObject.get("employeeID").toString(), "9");
            assertEquals(jsonObject.get("startTime").toString(), "1999-05-26T00:52:00");
            assertEquals(jsonObject.get("endTime").toString(), "1999-06-27T16:00:00");
        }
        @Test
        public void employeeParsingShouldMatchJSON () throws ParseException, IOException {
            String mockJSONFile = "src/mock_objects/mockEmployeesArray";
            JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);
            JSONObject jsonObject = (JSONObject) jsonArray.get(4);
            assertEquals(jsonObject.get("id").toString(), "5");
            assertEquals(jsonObject.get("surname").toString(), "Anderson");
            assertEquals(jsonObject.get("forename").toString(), "Stella");
        }
        @Test
        public void patientParsingShouldMatchJSON () throws ParseException, IOException {
            String mockJSONFile = "src/mock_objects/mockPatientsArray";
            JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            assertEquals(jsonObject.get("id").toString(), "1");
            assertEquals(jsonObject.get("surname").toString(), "File");
            assertEquals(jsonObject.get("forename").toString(), "Jason");
            assertEquals(jsonObject.get("nhsNumber").toString(), "12121212");
        }

/*
        private static Admission admission;
        @Before
        public void initialize(){
            admission = new Admission();
        }
*/
/*
        @Test
        public void allocationClassShouldBeAccuratelyFilled() throws ParseException, IOException {
            String mockJSONFile = "src/mock_objects/mockAdmissionsArray";
            JSONArray jsonArray = Getter.parseJsonToJsonArray(mockJSONFile);


            int expectedID = 1;

//            int actualID = admission.setAdmission(jsonArray, 0);

//            assertEquals(expectedID, admission.id);
        }

*/


    }

    @RunWith(Parameterized.class)
    public static class FunctionalMethodsTest {

        public static DateChecker dateChecker;
        public static String startDate;
        public static String endDate;

        @Before
        public void initialise() {
            dateChecker = new DateChecker();
        }

        public void DateChecker(String startDate, String endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        @Parameterized.Parameters
        public static Collection dateCheckerTestCollection() {
            return Arrays.asList(new Object[][]{
                    {"2020-11-28T23:56:00", "2020-11-28T23:56:00"},
                    {"2020-11-28T23:56:00", "2020-11-28T23:56:00"},
                    {"2020-11-28T23:56:00", "2020-11-28T23:56:00"},
                    {"2020-11-28T23:56:00", "2020-11-28T23:56:00"},
                    {"2020-11-28T23:56:00", "2020-11-28T23:56:00"}
            });
        }
        @Test
        public void dateCheckerShouldBeWithin3Days() {

            assertTrue(dateChecker.dateChecker(startDate, endDate));
        }

    }
}