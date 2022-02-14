package com.company;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Weather {
    private Location location;
    public static String weatherMain;
    public double tempFeelsLike;
    public double windSpeed;

    //connecting to weather API - main adress
     private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?";

    //adding necessary information to address
    private JSONObject getData(double latitude, double longitude) throws IOException {
        //getting individual API key from txt file located at the hard drive
        String appid = new String(Files.readAllBytes(Paths.get("appid/appid.txt")));
        var restapiConnector = new RESTAPIConnector();
        return restapiConnector.getObject(API_URL+ "lat=" + latitude  + "&lon=" + longitude +"&units=metric&appid=" + appid);
    }

     //picking needed information from API response
     public Weather(Location location) throws IOException {
         this.location = location;
         var weatherJSON = getData(location.latitude, location.longitude);
         JSONObject weatherTemp = (JSONObject) weatherJSON.getJSONArray("weather").get(0);
         weatherMain = weatherTemp.getString("main");
         tempFeelsLike = weatherJSON.getJSONObject("main").getDouble("feels_like");
         windSpeed = weatherJSON.getJSONObject("wind").getDouble("speed");
     }

    public String toString(){
        return "It's going to be " + weatherMain + ", temperature is: " + tempFeelsLike + " deg C";
    }

    public static String getWeatherMain(){return weatherMain;}

}