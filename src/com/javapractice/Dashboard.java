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
             menuSelection = menuScanner.nextInt();
            //validate input, should be 1,2,3, or 4
            inputIsValid = validateMenuInput(menuSelection);

        } while(!inputIsValid);

        //after validating input, redirect to appropriate functionality
        return handleMenuInput(menuSelection, parkingLot);
    }

    private static boolean validateMenuInput(int menuInput) {
        if (menuInput < 1 || menuInput > 4) {
            System.out.println("Please enter either 1, 2, 3, or 4.");
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
            parkCarResult = parkingLot.parkCar();
            if (parkCarResult != -1) {
                System.out.println("Your car was successfully parked at spot " + parkCarResult);
            }
            else System.out.println("Sorry, that spot is not available.");
        }
        else if (menuInput == 3) {
            removeCarResult = parkingLot.removeCar();
            if (removeCarResult) {
                System.out.println("Your car was successfully removed, have a nice day!");
            }
            else System.out.println("Car not found.");
        }
        else return menuInput == 4;

        return false;
    }
}
