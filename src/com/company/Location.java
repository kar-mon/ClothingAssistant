package com.company;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;

public class Location implements Serializable {
    //String name;
    double latitude;
    double longitude;
    String label;
    String city;
    String country;

    public Location(String label, String city, String country, double latitude, double longitude){
        this.label = label;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public void ListItem(String label, String city, String country) {
        this.label = label;
        this.city = city;
        this.country = country;
    }

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("label", label);
            obj.put("city", city);
            obj.put("country", country);
        } catch (JSONException e) {
        }
        return obj;
    }

    public String toString(){
        return label + ": " + city + ", " + country;
    }
    // add fields from example api response
    // parse, store
    // forward geocoding
    // query - ask user for an address, or country, region, etc and then use the query
    // check confidence

}
