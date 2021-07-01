package com.javapractice;

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

    public int parkCar(int spot, String make, String licensePlateNumber) {
        //check if lot is full before allowing user to park car

        if(isLotFull()) {
            return -2;
        }

        if(spot >= 0 && spot < 10) {
            if(parkedCars[spot] == null) {
                //spot is available, so we can park a car there

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

    private boolean isLotFull() {
        boolean lotIsFull = true;

        for (int i = 0; i < 10; i++) {
            if (parkedCars[i] == null) {
                lotIsFull = false;
                break;
            }
        }

        return lotIsFull;
    }

    public boolean removeCar(String licensePlateNumber) {

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

    public void setParkedCars(Car[] newParkedCars) {
        this.parkedCars = newParkedCars;
    }
}
