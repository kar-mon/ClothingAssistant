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
            System.out.println("0 - exit to main menu");

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
                case 0:
                    break;
                default:
                    System.out.println("It's not a valid option");
                    break;
            }
        } while (option != 0);

        saveLocations();
    }

    //exporting locations to a file
    private void saveLocations() {
        try {
            FileOutputStream fileOut = new FileOutputStream("locations.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(locations);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully exported locations");
    }

    //importing locations from a file created earlier
    public void loadLocations() {
        try {
            FileInputStream fis = new FileInputStream("locations.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            locations = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public void whatWearNow() throws IOException {
        System.out.println("Where are you? Enter location name:");
        String locationName = scanner.nextLine();
        Location choosenLocation = findLocation(locationName);
        if (choosenLocation == null) {
            System.out.println("Sorry, you should define " + locationName + " first");
            addLocations();
        } else {
            WeatherNow checkWeatherNow = new WeatherNow(choosenLocation);
            System.out.println(checkWeatherNow);
            Clothing clothing = new Clothing();
            System.out.println("You should think of: " + clothing.wardrobe(checkWeatherNow));
        }
    }

    private Location findLocation(String locationName) {
        for (Location l : locations)
            if (l.label.equals(locationName)) {
                return l;
            }
        return null;
    }

    public void whatWearTomorrow() throws IOException {
        Location work = findLocation("work");
        if (work == null) {
            System.out.println("Sorry, you should define work first");
            addLocations();
        } else {
            WeatherChecker checkWeatherTomorrow = new WeatherChecker(work, 0);
            System.out.println(checkWeatherTomorrow);
            Clothing clothing = new Clothing();
            System.out.println("You should think of: " + clothing.wardrobeTomorrow(checkWeatherTomorrow));
        }
    }

    public void whatWearSomewhere() throws IOException {
        System.out.println("Where would you like to go? Enter location name:");
        String locationName = scanner.nextLine();
        Location choosenLocation = findLocation(locationName);
        int index = 0;
        if (choosenLocation == null) {
            System.out.println("Sorry, you should define " + locationName + " first");
            addLocations();
        } else {
            System.out.println("Weather for which day would you like to check?");

            System.out.println("Check weather for:");
            System.out.println("0 - tomorrow");
            System.out.println("1 - day after tomorrow");
            System.out.println("2 - in 3 days");
            System.out.println("3 - in 4 days");
            System.out.println("4 - in 5 days");
            System.out.println("5 - in 6 days");
            System.out.println("6 - in 7 days");
            System.out.println("7 - in 8 days");
            System.out.println("9 - exit to main menu");

            index = Integer.parseInt(scanner.nextLine());

            if (index >= 9 || index < 0) {
                return;
            }

            WeatherChecker checkWeather = new WeatherChecker(choosenLocation, index);
            System.out.println(checkWeather);
            Clothing clothing = new Clothing();
            System.out.println("You should think of: " + clothing.wardrobeTomorrow(checkWeather));
        }
    }

    public void planATrip() {
    }
}
