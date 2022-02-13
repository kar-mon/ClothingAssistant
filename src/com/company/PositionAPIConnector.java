package com.company;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PositionAPIConnector {


    //connecting to positioning api
    private static String API_URL = "http://api.openweathermap.org/geo/1.0/direct?q=";


    // public static final String API_URL = "http://api.openweathermap.org/geo/1.0/direct?q=";


    //adding necessary information to address
    public JSONArray getData(String cityName, String countryCode ) throws IOException {
        //getting individual API key from txt file located at the hard drive
        String appid = new String(Files.readAllBytes(Paths.get("appid/appid.txt")));
        var restapiConnector = new RESTAPIConnector();
        return restapiConnector.getArray(API_URL+ cityName +","  + countryCode +"&appid=" + appid);
    }

    public String name;
    public double latitude;
    public double longitude;

    //picking needed information from API response
    public PositionAPIConnector(String cityName, String countryCode) throws IOException {
        var placeJSON = getData(cityName,countryCode);

        name = placeJSON.getJSONObject(0).getString("name");
        latitude = placeJSON.getJSONObject(0).getDouble("lat");
        longitude = placeJSON.getJSONObject(0).getDouble("lon");
    }

    public String toString(){
        return name + " " + latitude + " " + longitude;
    }

}
