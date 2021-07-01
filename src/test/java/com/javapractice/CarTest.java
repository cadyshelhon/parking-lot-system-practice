package com.javapractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getLicensePlateNumber() {
        //given a car object with make "CHEVY" and licno "1234"
        Car testCar = new Car("CHEVY", "1234");
        //When getting License Plate number
        String actual = testCar.getLicensePlateNumber();

        //then returned value should match

        assertEquals("1234", actual);
    }

    @Test
    void getFormattedInfo() {
        //given a car object with make "CHEVY" and licno "1234"
        Car testCar = new Car("CHEVY", "1234");
        //When getFormattedInfo() is called, return "-CHEVY-1234"
        String actual = testCar.getFormattedInfo();

        //then returned value should match

        assertEquals("-CHEVY-1234", actual);
    }
}