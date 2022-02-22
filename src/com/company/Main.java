package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Assistant assistant = new Assistant();

        int option;

        //menu for the user
        do{
            System.out.println("Hi, this is your Clothing Assistant");
            System.out.println("You have those options: ");
            System.out.println("1 - add locations");
            System.out.println("2 - load saved locations");
            System.out.println("3 - check what you should wear now");
            System.out.println("4 - check what you should wear tomorrow to work");
            System.out.println("5 - check what should you wear at chosen location on some other day");
            System.out.println("0 - exit");
            System.out.println("What do you want to do next?");

            option = scanner.nextInt();

            switch (option){
                case 1: assistant.addLocations();break;
                case 2: assistant.loadLocations();break;
                case 3: assistant.whatWearNow();break;
                case 4: assistant.whatWearTomorrow();break;
                case 5: assistant.whatWearSomewhere();break;
                case 0: break;
                default:
                    System.out.println("It's not a valid option"); break;
            }
        } while (option !=0);
    }
}
