package com.company;

import org.json.JSONObject;
import java.io.IOException;

public class weatherAPIConnector {
    //private static String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Gdansk&appid=3519263b643f37e949252d7516455726&units=metric";
     private static String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";


    public JSONObject getData(String Location) throws IOException {
        var restapiConnector = new RESTAPIConnector();
        return restapiConnector.getData(API_URL+ Location +"&appid=3519263b643f37e949252d7516455726&units=metric");
    }
}