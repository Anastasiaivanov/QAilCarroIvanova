package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestBase{

    @Test
    public void homePageTest() {
        //System.out.println("Open site");
        //System.out.println("FindCarFromPresent: " + isFindCarFromPresent1());
        //System.out.println("FindCarFromPresent: " + app.getCar().isFindCarFromPresent1());
        //app.getCar().isFindCarFromPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
        app.getCar().jumpToFooter();
        app.getFooter().openTopCityFromFooter(By.xpath("//a[contains(text(),'New York')]"));
        app.getFooter().openSocialMediaFromFooter(By.cssSelector(".facebook"));
    }

}
