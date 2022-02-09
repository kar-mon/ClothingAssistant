package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Assistant assistant = new Assistant();

        int option;

       /* do{
            System.out.println("Hi, this is your Clothing Assistant");
            System.out.println("You have those options: ");
            System.out.println("1 - add locations");
            System.out.println("2 - check what you should wear now");
            System.out.println("3 - check what you should wear tomorrow");
            System.out.println("4 - what should you wear at some other location");
            System.out.println("5 - plan a trip");
            System.out.println("0 - exit");

            option = scanner.nextInt();

            switch (option){
                case 1: assistant.addLocations();break;
                case 2: assistant.whatWearNow();break;
                case 3: assistant.whatWearTomorrow();break;
                case 4: assistant.whatWearSomewhere();break;
                case 5: assistant.planATrip();break;
                case 0: break;
                default:
                    System.out.println("It's not a valid option"); break;
            }

        } while (option !=0);*/

        var weather = new weatherAPIConnector();
        var weatherNow = weather.getData("Gdansk");
        System.out.println(weatherNow);

    }
}
