package com.ilcarro.qa11.framework;

import com.ilcarro.qa11.model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase{

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isFindCarFromPresent1() { //возвращ ошибка что не найден, если 0: false-ошибка
        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size() > 0;
    }

    public void fillCarForm(Car car) {
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
