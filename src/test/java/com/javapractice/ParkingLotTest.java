package com.javapractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void should_ReturnNegative2_WhenParkingLotFull() {
        ParkingLot testLot = new ParkingLot();
        Car[] parkedCars = new Car[10];

        for (int i = 0; i < parkedCars.length; i++) {
            parkedCars[i] = new Car("Chevy", "1234");
        }

        //given that the lot contains 10 cars
        testLot.setParkedCars(parkedCars);

        //when parkCar() is called
        int actual = testLot.parkCar(1, "chevy", "1234");
        int expected = -2;

        //then return -2
        assertEquals(expected,actual);
    }

   @ParameterizedTest(name = "spotNumber={0}")
   @CsvSource(value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void should_ReturnNegative1_WhenSpotIsTaken(int spot) {
        //given that the spot <number> is occupied
        ParkingLot testLot = new ParkingLot();
        Car[] parkedCars = new Car[10];
        parkedCars[spot] = new Car("chevy", "1234");
        testLot.setParkedCars(parkedCars);

        //when parkCar() is called and <number> is given
        int actual = testLot.parkCar(spot, "chevy", "1234");
        int expected = -1;

        //then return -1
       assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "spotNumber={0}")
    @CsvSource(value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void should_Return0through9_WhenParkedSuccessfully(int spot) {
        //given that the spot <number> is not ccupied
        ParkingLot testLot = new ParkingLot();
        Car[] parkedCars = new Car[10];
        testLot.setParkedCars(parkedCars);

        //when parkCar() is called and <number> is given
        int actual = testLot.parkCar(spot, "chevy", "1234");

        //then return spot
        assertEquals(spot, actual);
    }

    @ParameterizedTest(name = "spotNumber={0}")
    @CsvSource(value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void should_ReturnTrue_WhenCarRemovingSuccessful(int spot) {
        //given that a car exists with <licno>
        ParkingLot testLot = new ParkingLot();
        Car[] parkedCars = new Car[10];
        testLot.setParkedCars(parkedCars);
        parkedCars[spot] = new Car("chevy", "1234");
        //when removeCar(<licno>) is called
        boolean actual = testLot.removeCar("1234");

        //then return true
        assertTrue(actual);
    }

    @Test
    void should_ReturnFalse_WhenCarNotFound() {
        //given that a car does not exist with <licno>
        ParkingLot testLot = new ParkingLot();
        //when removeCar(<licno>) is called
        boolean actual = testLot.removeCar("1234");

        //then return false
        assertFalse(actual);
    }
}