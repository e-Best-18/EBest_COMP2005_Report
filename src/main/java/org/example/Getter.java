package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Getter {



    public static JSONArray getter(URL url) {

        HttpURLConnection conn = null;

        try {

            conn = Connection.connect(url);

            int status = Connection.getResponseCode(url);

            if (status != 200) {
                throw new RuntimeException(String.valueOf(status));
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                String stringToParse = String.valueOf(informationString);

                return Admission.parseAdmissionJSON(stringToParse);

            }

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            conn.disconnect();
        }

    }

}
