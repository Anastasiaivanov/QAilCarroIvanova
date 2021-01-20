package com.ilcarro.qa11.model;

public class Car {
    private String country;
    private String address;
    private String distance;
    private String serialNumber;
    private String brand;
    private String model;
    private String year;
    private String engine;
    private String fuelConsumption;
    private String fuel;
    private String transmission;
    private String wd;
    private String horsePower;
    private String torque;
    private String doors;
    private String seats;
    private String classCar;
    private String about;
    private String features;
    private String pricePerDay;

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public String getFuel() {
        return fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getWd() {
        return wd;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public String getTorque() {
        return torque;
    }

    public String getDoors() {
        return doors;
    }

    public String getSeats() {
        return seats;
    }

    public String getClassCar() {
        return classCar;
    }

    public String getAbout() {
        return about;
    }

    public String getFeatures() {
        return features;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public Car setCountry(String country) {
        this.country = country;
        return this;
    }

    public Car setAddress(String address) {
        this.address = address;
        return this;
    }

    public Car setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public Car setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setYear(String year) {
        this.year = year;
        return this;
    }

    public Car setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Car setWd(String wd) {
        this.wd = wd;
        return this;
    }

    public Car setHorsePower(String horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public Car setTorque(String torque) {
        this.torque = torque;
        return this;
    }

    public Car setDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car setSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car setClassCar(String classCar) {
        this.classCar = classCar;
        return this;
    }

    public Car setAbout(String about) {
        this.about = about;
        return this;
    }

    public Car setFeatures(String features) {
        this.features = features;
        return this;
    }

    public Car setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}