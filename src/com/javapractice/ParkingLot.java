package com.javapractice;

import java.util.Scanner;

public class ParkingLot {

    private Car[] parkedCars = new Car[10];

    public void printParkingLot() {
        for (int i = 0; i < 10; i++) {
            if (parkedCars[i] == null) {
                System.out.println(i + "-UNOCCUPIED");
            }
            else {
                System.out.println(i + parkedCars[i].getFormattedInfo());
            }

        }
    }

    public int parkCar() {
        int spot;
        String make;
        String licensePlateNumber;
        Scanner carInput = new Scanner(System.in);

        //ask user for the spot they want to park at
        System.out.print("Enter parking spot number: ");
        spot = carInput.nextInt();
        if(spot >= 0 && spot < 10) {
            if(parkedCars[spot] == null) {
                //spot is available, so we can park a car there

                //ask user for make of car
                System.out.print("Enter the make of your car: ");
                make = carInput.next();

                //ask user for license plate number
                System.out.print("Enter your license plate number: ");
                licensePlateNumber = carInput.next();

                //create new car
                Car carToPark = new Car(make, licensePlateNumber);

                //park car
                parkedCars[spot] = carToPark;

                return spot;
            }
            else {
                return -1;
            }
        }
        else return -1;

    }

    public boolean removeCar() {
        String licensePlateNumber;
        Scanner carInput = new Scanner(System.in);

        //ask user for the spot they want to park at
        System.out.print("Enter the license plate number of the car to remove: ");
        licensePlateNumber = carInput.next();

        //now look through the parking lot to see if a car's licNo matches
        for (int i = 0; i < 10; i++) {
            if(parkedCars[i] != null) {
                if (parkedCars[i].getLicensePlateNumber().equals(licensePlateNumber)) {
                    //we found the car! now lets remove it and return true
                    parkedCars[i] = null;
                    return true;
                }
            }
        }
        //we have looked through all the cars and have not found the car, return false
        return false;
    }
}
