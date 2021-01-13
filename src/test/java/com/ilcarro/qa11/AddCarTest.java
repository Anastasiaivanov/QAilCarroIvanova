package com.ilcarro.qa11;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
    }

    @Test
    public void negativeTestWithoutDoors() {
        app.getHeader().openAddCarFormFromHeader();
        app.getCar().fillCarForm(new Car().setCountry("Germany")
                .setAddress("Fridrichstrasse 41, 10115 Berlin")
                .setDistance(500)
                .setSerialNumber("123-123-123")
                .setBrand("BMW")
                .setModel("X3")
                .setYear(2010)
                .setEngine("CF.1234")
                .setFuelConsumption(10)
                .setFuel("Diesel")
                .setTransmission("back")
                .setWd("RWD")
                .setHorsePower(110)
                .setTorque(123)
                .setSeats(5)
                .setClassCar("B")
                .setAbout("Comfortable and speedy car")
                .setFeatures("good")
                .setPricePerDay(30));
        app.getUser().submitForm();
    }

    public void testFormLetTheCarWorkForLoggedUser() {
        if (!app.getUser().userLoggedIn()) {
            app.getUser().logIn();
        }
        app.getHeader().openAddCarFormFromHeader();
        app.getCar().fillCarForm(new Car().setCountry("Germany")
                .setAddress("Fridrichstrasse 41, 10115 Berlin")
                .setDistance(500)
                .setSerialNumber("123-123-123")
                .setBrand("BMW")
                .setModel("X3")
                .setYear(2010)
                .setEngine("CF.1234")
                .setFuelConsumption(10)
                .setFuel("Diesel")
                .setTransmission("back")
                .setWd("RWD")
                .setHorsePower(110)
                .setTorque(123)
                .setDoors(5)
                .setSeats(5)
                .setClassCar("B")
                .setAbout("Comfortable and speedy car")
                .setFeatures("good")
                .setPricePerDay(30));
        app.getUser().submitForm();
    }

    public void testFormLetTheCarWorkForNotLoggedUser() {

        app.getHeader().openAddCarFormFromHeader();
        app.getCar().fillCarForm(new Car().setCountry("Germany")
                .setAddress("Fridrichstrasse 41, 10115 Berlin")
                .setDistance(500)
                .setSerialNumber("123-123-123")
                .setBrand("BMW")
                .setModel("X3")
                .setYear(2010)
                .setEngine("CF.1234")
                .setFuelConsumption(10)
                .setFuel("Diesel")
                .setTransmission("back")
                .setWd("RWD")
                .setHorsePower(110)
                .setTorque(123)
                .setDoors(5)
                .setSeats(5)
                .setClassCar("B")
                .setAbout("Comfortable and speedy car")
                .setFeatures("good")
                .setPricePerDay(30));
        app.getUser().submitForm();
    }
}
