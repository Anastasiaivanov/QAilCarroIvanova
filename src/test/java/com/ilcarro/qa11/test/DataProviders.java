package com.ilcarro.qa11.test;

import com.ilcarro.qa11.model.Car;
import com.ilcarro.qa11.model.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"aName", "bName", "aName4@mail.com", "Abcde1234ana"});
        list.add(new Object[]{"cName", "dName", "bName5@mail.com", "Abcde1235ana"});
        list.add(new Object[]{"eName", "fName", "cName6@mail.com", "Abcde1236ana"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader =
                new BufferedReader(new FileReader("src/test/resources/newUser.csv"));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0]).setSecondName(split[1]).setEmail(split[2]).setPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validCarFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader =
                new BufferedReader(new FileReader("src/test/resources/addCar.csv"));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Car().setCountry(split[0])
                    .setAddress(split[1])
                    .setDistance(split[2])
                    .setSerialNumber(split[3])
                    .setBrand(split[4])
                    .setModel(split[5])
                    .setYear(split[6])
                    .setEngine(split[7])
                    .setFuelConsumption(split[8])
                    .setFuel(split[9])
                    .setTransmission(split[10])
                    .setWd(split[11])
                    .setHorsePower(split[12])
                    .setTorque(split[13])
                    .setDoors(split[14])
                    .setSeats(split[15])
                    .setClassCar(split[16])
                    .setAbout(split[17])
                    .setFeatures(split[18])
                    .setPricePerDay(split[19])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
