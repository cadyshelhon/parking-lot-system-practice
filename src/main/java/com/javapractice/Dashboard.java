package com.javapractice;

import java.util.Scanner;

public class Dashboard {

    public static void startDashboard() {
        boolean exit = false;
        ParkingLot parkingLot = new ParkingLot();

        while (!exit) {
            printMenu();
            exit = acceptMenuSelection(parkingLot);
        }
    }

    private static void printMenu() {
        System.out.println("--- PARKING LOT MENU ---");
        System.out.println();
        System.out.println("1. Show Parking Lot Spots");
        System.out.println("2. Park Car");
        System.out.println("3. Remove Car");
        System.out.println("4. Exit");
        System.out.println();
    }

    private static boolean acceptMenuSelection(ParkingLot parkingLot) {
        Scanner menuScanner = new Scanner(System.in);
        boolean inputIsValid;
        int menuSelection;
        System.out.print("Enter an option: ");


        //keep asking for input until user enters a valid option
        do {
            //get input
            // validate input, should be 1,2,3, or 4, should not be a string or char
            while(!menuScanner.hasNextInt()) {
                System.out.print("Please enter a number: ");
                menuScanner.next();
            }
                menuSelection = menuScanner.nextInt();

                inputIsValid = validateMenuInput(menuSelection);



        } while(!inputIsValid);

        //after validating input, redirect to appropriate functionality
        return handleMenuInput(menuSelection, parkingLot);
    }

    private static boolean validateMenuInput(int menuInput) {
        if (menuInput < 1 || menuInput > 4) {
            System.out.print("Please enter either 1, 2, 3, or 4: ");
            return false;
        }
        else
            return true;
    }

    private static boolean handleMenuInput(int menuInput, ParkingLot parkingLot) {

        int parkCarResult;
        boolean removeCarResult;

        if (menuInput == 1) {
            parkingLot.printParkingLot();
        }
        else if (menuInput == 2) {
            Scanner carInput = new Scanner(System.in);

            //ask user for the spot they want to park at
            System.out.print("Enter parking spot number: ");
            int spot = carInput.nextInt();

            //ask user for make of car
            System.out.print("Enter the make of your car: ");
            String make = carInput.next();

            //ask user for license plate number
            System.out.print("Enter your license plate number: ");
            String licensePlateNumber = carInput.next();

            parkCarResult = parkingLot.parkCar(spot, make, licensePlateNumber);
            if (parkCarResult != -1 && parkCarResult != -2) {
                System.out.println("Your car was successfully parked at spot " + parkCarResult);
            }
            else if(parkCarResult == -1) System.out.println("Sorry, that spot is not available.");
            else if(parkCarResult == -2) System.out.println("Parking lot is full!");
        }
        else if (menuInput == 3) {
            Scanner carInput = new Scanner(System.in);

            //ask user for the spot they want to park at
            System.out.print("Enter the license plate number of the car to remove: ");
            String licensePlateNumber = carInput.next();
            removeCarResult = parkingLot.removeCar(licensePlateNumber);
            if (removeCarResult) {
                System.out.println("Your car was successfully removed, have a nice day!");
            }
            else System.out.println("Car not found.");
        }
        else return menuInput == 4;

        return false;
    }
}
