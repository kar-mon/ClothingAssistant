package com.company;

import java.time.LocalDateTime;
import java.util.*;

public class Assistant {
    Scanner scanner = new Scanner(System.in);

    Location home;
    Location work;
    List<Location> otherLocations;

    Map<String, Location> locations = new HashMap<>();

    public void addLocations() {
    }

    public void whatWearNow() {
        System.out.println("Where are you?");
        String locationName = scanner.nextLine();
        Location choosenLocation = findLocation(locationName);
        Forecast forecast = new Forecast(choosenLocation, new Date());
        List<Clothing> clothing = forecast.getClothingList();

        System.out.println("You should wear: ");
        for(Clothing cloth : clothing) {
            System.out.println(cloth);
        }
    }

    private location findLocation(String locationName) {
        switch (locationName){
            case "home": return home;
            case  "work": return work;
            default:for(location l : otherLocations)
                if (l.name.equals(locationName)) {
                    return l;
                }
        } return null;
    }

    public void whatWearTomorrow() {
        Location work = findLocation("work");
        if(work == null){
            System.out.println("Sorry, you should define work first");
            addLocations();} else {
            Date date = new Date();
            //LocalDateTime.from(date.toInstant().plusDays(1));
            //todo: add one day to today
            Forecast forecast = new Forecast(work, date);
            List<Clothing> clothing = forecast.getClothingList();

            System.out.println("You should wear: ");
            for (Clothing cloth: cloting) {
                System.out.println(cloth);
            }

        }
    }

    public void whatWearSomewhere() {
    }

    public void planATrip() {

    }

}
