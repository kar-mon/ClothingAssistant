package com.company;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTAPIConnector {

        public JSONObject getData(String API_URL) throws IOException {

        URL url = new URL(API_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        System.out.println("Connected");

        int status = connection.getResponseCode();
        System.out.println("Status: " + status);

        BufferedReader in = new BufferedReader( //for efficiency

                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

       return new JSONObject(new JSONTokener(content.toString()));
    }
}