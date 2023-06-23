package main.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class InvoiceGeneratorHTTP {

    private String API = "http://deus.carloscasado.es:19132/data";
    private URL url;
    private HttpURLConnection connection;
    private byte[] body;
    private StringBuilder base;
    private StringBuilder responseBody;

    public InvoiceGeneratorHTTP() {
        try {
            url = new URL(API);
            connection = (HttpURLConnection) url.openConnection();
            responseBody = new StringBuilder();
            base = new StringBuilder("{");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //@@ https://www.programiz.com/java-programming/examples/even-odd
    //@@ https://www.sanfoundry.com/java-program-print-odd-even-numbers-array/
    /*
    #########################################################################
    * First: generate a basic JSON with a String array; where the odd numbers
    * are the property titles, and the even numbers are the property results.
    #########################################################################
     */

    public String generateInvoice(String... info) {

        if(info.length % 2 == 0)
            for(int i = 0 ; i < info.length ; i++) {
                if(i % 2 == 0) { base.append("\"").append(info[i]).append("\":\""); }
                if(i % 2 != 0) {
                    base.append(info[i]).append("\"");
                    if ((info.length - 1) != i) base.append(","); //eliminates the last comma to parse correctly the JSON
                }
            }

        base.append("}");
        return connectHTTP(base.toString());

    }

    public String connectHTTP(String input) {

        try {
            //Handles the connection properties
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            body = input.getBytes(StandardCharsets.UTF_8);

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(body, 0, body.length);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }

            }

            connection.disconnect();
            return responseBody.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
