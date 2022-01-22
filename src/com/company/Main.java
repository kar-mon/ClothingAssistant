package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Assistant assistant = new Assistant();

        int option;

        do{
            System.out.println("Hi, here is your Clothing Assistant");
            System.out.println("You have that options: ");
            System.out.println("1 - add locations");
            System.out.println("2 - check what you should wear now");
            System.out.println("3 - check what you should wear tomorrow");
            System.out.println("4 - what should you wear at some other location");
            System.out.println("5 - plan a trip");
            System.out.println("0 - exit");

            option = scanner.nextInt();

            switch (option){
                case 1: addLocations();break;
                case 2: whatWearNow();break;
                case 3: whatWearTomorrow();break;
                case 4: whatWearSomewhere();break;
                case 5: planATrip();break;
                case 0: break;
                default:
                    System.out.println("it's not a valid option"); break;
            }

        } while (option !=0);
    }


}
