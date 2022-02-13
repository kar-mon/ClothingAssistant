package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//class for connecting to different APIs
public class RESTAPIConnector {

        private String getData (String API_URL) throws IOException {
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

                return content.toString();
        }

        public JSONObject getObject(String API_URL) throws IOException {

       return new JSONObject(new JSONTokener(getData(API_URL)));
    }

        public JSONArray getArray(String API_URL) throws IOException {

        return new JSONArray(new JSONTokener(getData(API_URL)));
        }
}