package com.company;

public class Location {
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

    public String toString(){
        return label + ": " + city + ", " + country;
    }
    // add fields from example api response
    // parse, store
    // forward geocoding
    // query - ask user for an address, or country, region, etc and then use the query
    // check confidence

}
