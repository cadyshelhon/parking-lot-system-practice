package com.javapractice;

public class Car {
    private String make;
    private String licensePlateNumber;

    public Car(String make, String licensePlateNumber) {
        setMake(make);
        setLicensePlateNumber(licensePlateNumber);
    }

    private void setMake(String make) {
        this.make = make;
    }

    private void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getFormattedInfo() {
        return "-" + make + "-" + licensePlateNumber;
    }


}
