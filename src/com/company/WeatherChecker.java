package com.company;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WeatherChecker {

    private Location location;
    public static String weatherTomorrow;
    public double tempFeelsLike;

    //connecting to weather API - main address
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/onecall?";


    //adding necessary information to address
    private JSONObject getData(double latitude, double longitude) throws IOException {
        //getting individual API key from txt file located at the hard drive
        String appid = new String(Files.readAllBytes(Paths.get("appid/appid.txt")));
        var restapiConnector = new RESTAPIConnector();
        return restapiConnector.getObject(API_URL+ "lat=" + latitude  + "&lon=" + longitude + "&exclude=minutely,hourly" +"&units=metric&appid=" + appid);
    }

    //picking needed information from API response
    public WeatherChecker(Location location, int index) throws IOException {
        this.location = location;
        var weatherJSON = getData(location.latitude, location.longitude);
        JSONObject weatherTemp = (JSONObject) weatherJSON.getJSONArray("daily").get(index);
        JSONObject weather = (JSONObject) weatherTemp.getJSONArray("weather").get(0);
        weatherTomorrow = weather.getString("main");
        tempFeelsLike = weatherTemp.getJSONObject("feels_like").getDouble("day");
    }

    public String toString(){
        return "It's going to be " + weatherTomorrow + ", temperature: " + tempFeelsLike + " deg C";
    }

    public double getTempFeelsLike(){return tempFeelsLike;}
}
