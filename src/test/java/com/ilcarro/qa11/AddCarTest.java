package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

    }

    @Test
    public void addCar() {
        click(By.cssSelector("[href='/car']"));
        fillCarForm(new Car().setCountry("Germany")
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
        submitForm();
    }

    private void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), String.valueOf(car.getDistance()));
        type(By.cssSelector(".serial_number"), car.getSerialNumber());
        type(By.cssSelector(".brand"), car.getBrand());
        type(By.cssSelector(".model"), car.getModel());
        type(By.cssSelector(".year"), String.valueOf(car.getYear()));
        type(By.cssSelector(".engine"), car.getEngine());
        type(By.cssSelector(".fuel_consumption"), String.valueOf(car.getFuelConsumption()));
        type(By.cssSelector(".fuel"), car.getFuel());
        type(By.cssSelector(".transmition"), car.getTransmission());
        type(By.cssSelector(".wd"), car.getWd());
        type(By.cssSelector(".horsepower"), String.valueOf(car.getHorsePower()));
        type(By.cssSelector(".torque"), String.valueOf(car.getTorque()));
        type(By.cssSelector(".doors"), String.valueOf(car.getDoors()));
        type(By.cssSelector(".seats"), String.valueOf(car.getSeats()));
        type(By.cssSelector(".class"), car.getClassCar());
        type(By.cssSelector("[name='about']"), car.getAbout());
        type(By.cssSelector(".type_feature"), car.getFeatures());
        type(By.cssSelector(".price"), String.valueOf(car.getPricePerDay()));

    }
}
