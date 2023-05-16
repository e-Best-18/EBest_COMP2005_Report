package org.example;

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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

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
/*
            System.out.println("URL is: " + url);
            System.out.println("Code is: " + connection.getResponseCode(url));
*/
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




}