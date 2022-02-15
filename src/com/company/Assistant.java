package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assistant {

    Scanner scanner = new Scanner(System.in);

    List<Location> locations = new ArrayList<>();
    String cityName;
    String countryCode;
    String label;


    //Map<String, Location> locations = new HashMap<>();

    public void addLocations() throws IOException {
        int option;
        do {
            System.out.println("Add new location");
            System.out.println("1 - add home location");
            System.out.println("2 - add work location");
            System.out.println("3 - add other location");
            System.out.println("9 - exit to main menu");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1: {
                    System.out.println("enter city name");
                    cityName = scanner.nextLine();
                    System.out.println("enter country code");
                    countryCode = scanner.nextLine();
                    var homePosition = new PositionAPIConnector(cityName, countryCode);
                    locations.add(new Location("home", cityName, countryCode, homePosition.latitude, homePosition.longitude));
                }
                break;
                case 2: {
                    System.out.println("enter city name");
                    cityName = scanner.nextLine();
                    System.out.println("enter country code");
                    countryCode = scanner.nextLine();
                    var workPosition = new PositionAPIConnector(cityName, countryCode);
                    locations.add(new Location("work", cityName, countryCode, workPosition.latitude, workPosition.longitude));
                }
                break;
                case 3: {
                    System.out.println("How many locations do you want to add?");
                    int size = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < size; i++) {
                        System.out.println("enter location name");
                        label = scanner.nextLine();
                        System.out.println("enter city name");
                        cityName = scanner.nextLine();
                        System.out.println("enter country code");
                        countryCode = scanner.nextLine();
                        var otherPosition = new PositionAPIConnector(cityName, countryCode);
                        locations.add(new Location(label, cityName, countryCode, otherPosition.latitude, otherPosition.longitude));
                    }
                }
                break;
                case 9:
                    break;
                default:
                    System.out.println("It's not a valid option");
                    break;
            }
        } while (option != 9);

        //exporting locations to a file

        /*try{FileWriter writer = new FileWriter("locations.ser");
        for (Location loc : locations) {
            writer.write(loc + System.lineSeparator());
        }
        writer.close();}catch (IOException e) {
            e.printStackTrace();}*/

        try {
            FileOutputStream writeData = new FileOutputStream("locations.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(locations);
            writeStream.flush();
            writeStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void whatWearNow() throws IOException {
        System.out.println("Where are you? Enter location name:");
        String locationName = scanner.nextLine();
        Location choosenLocation = findLocation(locationName);
        Weather checkWeather = new Weather(choosenLocation);
        System.out.println(checkWeather);
        Clothing clothing = new Clothing();
        System.out.println("You should think of: " + clothing.wardrobe(checkWeather));
    }

    private Location findLocation(String locationName) {
        for (Location l : locations)
            if (l.label.equals(locationName)) {
                return l;
            }
        return null;
    }

    /*public void whatWearTomorrow() {
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
            for (Clothing cloth: clothing) {
                System.out.println(cloth);
            }

        }
    }*/

    public void whatWearSomewhere() {

    }

    public void planATrip() {
    }
}
